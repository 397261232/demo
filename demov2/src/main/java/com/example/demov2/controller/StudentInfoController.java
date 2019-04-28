package com.example.demov2.controller;

import com.example.demov2.constant.BaseContants;
import com.example.demov2.dto.ScoreInfoDTO;
import com.example.demov2.dto.StudentInfoDTO;
import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.dto.response.BaseResponse;
import com.example.demov2.dto.response.ListScoreResponse;
import com.example.demov2.dto.response.StudentInfoListResponse;
import com.example.demov2.dto.response.StudentInfoResponse;
import com.example.demov2.model.ScoreInfo;
import com.example.demov2.model.StudentInfo;
import com.example.demov2.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/26 15:48
 * @Modified By:
 */
@RestController
@RequestMapping("student")
public class StudentInfoController {

    @Autowired
    private StudentService studentService;

    static private Logger logger = LoggerFactory.getLogger(Object.class);

    @PostMapping(value = "id")
    public BaseResponse getStudentById(@RequestParam Integer id) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            StudentInfo op = studentService.readStudentById(id);
            StudentInfoResponse studentInfoResponse = new StudentInfoResponse();
            studentInfoResponse.setStudentAge(op.getStudentAge());
            studentInfoResponse.setStudentId(op.getStudentId());
            studentInfoResponse.setStudentName(op.getStudentName());
            if ("1".equals(op.getStudentSex())) {
                studentInfoResponse.setStudentSex("男");
            } else if ("0".equals(op.getStudentSex())) {
                studentInfoResponse.setStudentSex("女");
            }
            baseResponse.setData(studentInfoResponse);
            baseResponse.setCode(BaseContants.SUCCESS_CODE);
            baseResponse.setMessage(BaseContants.SUCCESS_MESSAGE);
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setCode(BaseContants.ERROR_CODE);
            baseResponse.setMessage(BaseContants.ERROR_MESSAGE + e.getMessage());
            return baseResponse;
        }
    }

    @PostMapping(value = "list")
    public BaseResponse listStudent(@RequestBody StudentInfoDTO studentInfoDto) {
        BaseResponse baseResponse = new BaseResponse();
        StudentInfoListResponse studentInfoListResponse = new StudentInfoListResponse();
        List<StudentInfoResponse> studentInfoResponseList = new ArrayList<>();
        try {
            List<StudentInfo> op = studentService.listStudent(studentInfoDto);
            for (StudentInfo si : op) {
                StudentInfoResponse studentInfo = new StudentInfoResponse();
                studentInfo.setStudentId(si.getStudentId());
                studentInfo.setStudentAge(si.getStudentAge());
                studentInfo.setStudentName(si.getStudentName());
                if ("1".equals(si.getStudentSex())) {
                    studentInfo.setStudentSex("男");
                } else if ("0".equals(si.getStudentSex())) {
                    studentInfo.setStudentSex("女");
                }
                studentInfoResponseList.add(studentInfo);
            }
            studentInfoListResponse.setStudentInfoResponseList(studentInfoResponseList);
            Integer total = studentService.countStudentList(studentInfoDto);
            studentInfoListResponse.setTotal(total);
            baseResponse.setData(studentInfoListResponse);
            baseResponse.setCode(BaseContants.SUCCESS_CODE);
            baseResponse.setMessage(BaseContants.SUCCESS_MESSAGE);
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setCode(BaseContants.ERROR_CODE);
            baseResponse.setMessage(BaseContants.ERROR_MESSAGE + e.getMessage());
            return baseResponse;
        }
    }

    @PostMapping(value = "save")
    public BaseResponse saveStudent(@RequestBody StudentInfoDTO studentInfoDto) {
        BaseResponse baseResponse = new BaseResponse();
        StudentInfoDTO existStudent = new StudentInfoDTO();
        try {
            existStudent.setStudentId(studentInfoDto.getStudentId());
            Integer total = studentService.countStudentList(existStudent);
            if (total != 0) {
                baseResponse.setCode(BaseContants.ERROR_CODE);
                logger.error("学号重复");
                baseResponse.setMessage("学号重复");
                return baseResponse;
            }
            studentService.saveStudent(studentInfoDto);
            baseResponse.setCode(BaseContants.SUCCESS_CODE);
            baseResponse.setMessage(BaseContants.SUCCESS_MESSAGE);
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setCode(BaseContants.ERROR_CODE);
            baseResponse.setMessage(BaseContants.ERROR_MESSAGE + e.getMessage());
            return baseResponse;
        }
    }

    @PostMapping(value = "update")
    public BaseResponse updateStudent(@RequestBody StudentInfoDTO studentInfoDto) {
        BaseResponse baseResponse = new BaseResponse();
        StudentInfoDTO existStudent = new StudentInfoDTO();
        try {
            if (!StringUtils.isEmpty(studentInfoDto.getStudentId())) {
                existStudent.setStudentId(studentInfoDto.getStudentId());
                List<StudentInfo> studentInfoListResponse = studentService.listStudent(existStudent);
                StudentInfo op = studentService.readStudentById(studentInfoDto.getId());
                if (!CollectionUtils.isEmpty(studentInfoListResponse) && !op.getStudentId().equals(studentInfoDto.getStudentId())) {
                    baseResponse.setCode(BaseContants.ERROR_CODE);
                    logger.error("学号重复");
                    baseResponse.setMessage("学号重复");
                    return baseResponse;
                }
            }
            studentService.updateStudent(studentInfoDto);
            baseResponse.setCode(BaseContants.SUCCESS_CODE);
            baseResponse.setMessage(BaseContants.SUCCESS_MESSAGE);
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setCode(BaseContants.ERROR_CODE);
            baseResponse.setMessage(BaseContants.ERROR_MESSAGE + e.getMessage());
            return baseResponse;
        }
    }

    @PostMapping("score")
    public BaseResponse listScoreByStudent(@RequestBody ListScoreRequest scoreInfoDto) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            ListScoreResponse listScoreResponse = new ListScoreResponse();
            List<ScoreInfoDTO> scoreInfoDTOList = new ArrayList<ScoreInfoDTO>();
            List<ScoreInfo> op = studentService.listScoreByStudent(scoreInfoDto);
            for (ScoreInfo si : op) {
                ScoreInfoDTO scoreDto = new ScoreInfoDTO();
                scoreDto.setAvg(si.getAvg());
                scoreDto.setCourseId(si.getCourseInfo().getCourseId());
                scoreDto.setCourseName(si.getCourseInfo().getCourseName());
                scoreDto.setStudentId(si.getStudentInfo().getStudentId());
                scoreDto.setStudentName(si.getStudentInfo().getStudentName());
                scoreDto.setScore(si.getScore());
                scoreDto.setTerm(si.getTerm());
                scoreInfoDTOList.add(scoreDto);
            }
            listScoreResponse.setScoreInfoList(scoreInfoDTOList);
            Integer total = studentService.countScoreByStudent(scoreInfoDto);
            listScoreResponse.setTotal(total);
            baseResponse.setData(listScoreResponse);
            baseResponse.setCode(BaseContants.SUCCESS_CODE);
            baseResponse.setMessage(BaseContants.SUCCESS_MESSAGE);
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setCode(BaseContants.ERROR_CODE);
            baseResponse.setMessage(BaseContants.ERROR_MESSAGE + e.getMessage());
            return baseResponse;
        }
    }
}
