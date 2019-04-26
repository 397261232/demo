package com.example.demov2.controller;

import com.example.demov2.constant.BaseContants;
import com.example.demov2.dto.*;
import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.dto.response.BaseResponse;
import com.example.demov2.dto.response.ListScoreResponse;
import com.example.demov2.dto.response.StudentInfoListResponse;
import com.example.demov2.dto.response.StudentInfoResponse;
import com.example.demov2.model.ScoreInfo;
import com.example.demov2.service.ScoreService;
import com.example.demov2.service.StudentService;
import com.example.demov2.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/23 14:21
 * @Modified By:
 */
//@RestController
//@RequestMapping("school")
//public class SchoolController {
//    @Autowired
//    private StudentService studentService;
//
//    @Autowired
//    private ScoreService scoreService;
//
//    @Autowired
//    private TeacherService teacherService;
//
//
//    @PostMapping(value="student/id")
//    public BaseResponse getStudentById(HttpServletRequest request ){
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            Integer id = Integer.valueOf(request.getParameter("id"));
//            StudentInfoResponse op =  studentService.getStudentById(id);
//            baseResponse.setData(op);
//            baseResponse.setCode(BaseContants.SUCCESS);
//            return baseResponse;
//        } catch (Exception e) {
//            e.printStackTrace();
//            baseResponse.setCode(BaseContants.ERROR);
//            baseResponse.setMessage(e.getMessage());
//            return baseResponse;
//        }
//    }
//
//    @PostMapping(value="student/list")
//    public BaseResponse listStudent(@RequestBody StudentInfoDTO studentInfoDto){
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            StudentInfoListResponse op =  studentService.listStudent(studentInfoDto);
//            baseResponse.setData(op);
//            baseResponse.setCode(BaseContants.SUCCESS);
//            return baseResponse;
//        } catch (Exception e) {
//            e.printStackTrace();
//            baseResponse.setCode(BaseContants.ERROR);
//            baseResponse.setMessage(e.getMessage());
//            return baseResponse;
//        }
//    }
//
//    @PostMapping(value="student/save")
//    public BaseResponse saveStudent(@RequestBody StudentInfoDTO studentInfoDto){
//        BaseResponse baseResponse = new BaseResponse();
//        StudentInfoDTO existStudent = new StudentInfoDTO();
//        try {
//            existStudent.setStudentId(studentInfoDto.getStudentId());
//            String total = studentService.listStudent(existStudent).getTotal();
//            if (!"0".equals(total)) {
//                baseResponse.setCode(BaseContants.ERROR);
//                baseResponse.setMessage("学号重复");
//                return baseResponse;
//            }
//            studentService.saveStudent(studentInfoDto);
//            baseResponse.setCode(BaseContants.SUCCESS);
//            return baseResponse;
//        } catch (Exception e) {
//            e.printStackTrace();
//            baseResponse.setCode(BaseContants.ERROR);
//            baseResponse.setMessage(e.getMessage());
//            return baseResponse;
//        }
//    }
//
//    @PostMapping(value="student/update")
//    public BaseResponse updateStudent(@RequestBody StudentInfoDTO studentInfoDto){
//        BaseResponse baseResponse = new BaseResponse();
//        StudentInfoDTO existStudent = new StudentInfoDTO();
//        try {
//            if (!StringUtils.isEmpty(studentInfoDto.getStudentId())) {
//                existStudent.setStudentId(studentInfoDto.getStudentId());
//                List<StudentInfoResponse> studentInfoListResponse= studentService.listStudent(existStudent).getStudentInfoResponseList();
//                StudentInfoResponse op =  studentService.getStudentById(studentInfoDto.getId());
//                if (!CollectionUtils.isEmpty(studentInfoListResponse)&&!op.getStudentId().equals(studentInfoDto.getStudentId())){
//                        baseResponse.setCode(BaseContants.ERROR);
//                        baseResponse.setMessage("学号重复");
//                        return baseResponse;
//                }
//            }
//            studentService.updateStudent(studentInfoDto);
//            baseResponse.setCode(BaseContants.SUCCESS);
//            return baseResponse;
//        } catch (Exception e) {
//            e.printStackTrace();
//            baseResponse.setCode(BaseContants.ERROR);
//            baseResponse.setMessage(e.getMessage());
//            return baseResponse;
//        }
//    }
//
//    @PostMapping("master/score")
//    public BaseResponse listScoreMaster(@RequestBody ListScoreRequest scoreInfoRequest){
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            ListScoreResponse listScoreResponse = new ListScoreResponse();
//            List<ScoreInfoDTO> scoreInfoDTOList = new ArrayList<ScoreInfoDTO>();
//            List<ScoreInfo> op =  scoreService.listScoreAllByMaster(scoreInfoRequest);
//            for (ScoreInfo si : op) {
//                ScoreInfoDTO scoreInfoDto = new ScoreInfoDTO();
//                scoreInfoDto.setAvg(si.getAvg());
//                scoreInfoDto.setCourseId(si.getCourseInfo().getCourseId());
//                scoreInfoDto.setCourseName(si.getCourseInfo().getCourseName());
//                scoreInfoDto.setMax(si.getMax());
//                scoreInfoDto.setMin(si.getMin());
//                scoreInfoDto.setTerm(si.getTerm());
//                scoreInfoDTOList.add(scoreInfoDto);
//            }
//            listScoreResponse.setScoreInfoList(scoreInfoDTOList);
//            Integer total = scoreService.countScoreAllByMaster(scoreInfoRequest);
//            listScoreResponse.setTotal(total);
//            baseResponse.setData(listScoreResponse);
//            baseResponse.setCode(BaseContants.SUCCESS);
//            return baseResponse;
//        } catch (Exception e) {
//            e.printStackTrace();
//            baseResponse.setCode(BaseContants.ERROR);
//            baseResponse.setMessage(e.getMessage());
//            return baseResponse;
//        }
//    }
//
//    @PostMapping("master/teacher/score")
//    public BaseResponse listScoreTeacher(@RequestBody ListScoreRequest scoreInfoDto){
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            ListScoreResponse listScoreResponse = new ListScoreResponse();
//            List<ScoreInfoDTO> scoreInfoDTOList = new ArrayList<ScoreInfoDTO>();
//            List<ScoreInfo> op =  scoreService.listScoreTeacherByMaster(scoreInfoDto);
//            for (ScoreInfo si : op) {
//                ScoreInfoDTO scoreDto = new ScoreInfoDTO();
//                scoreDto.setAvg(si.getAvg());
//                scoreDto.setCourseId(si.getCourseInfo().getCourseId());
//                scoreDto.setCourseName(si.getCourseInfo().getCourseName());
//                scoreDto.setTeacherId(si.getTeacherInfo().getTeacherId());
//                scoreDto.setTeacherName(si.getTeacherInfo().getTeacherName());
//                scoreDto.setMax(si.getMax());
//                scoreDto.setMin(si.getMin());
//                scoreInfoDTOList.add(scoreDto);
//            }
//            listScoreResponse.setScoreInfoList(scoreInfoDTOList);
//            Integer total = scoreService.countScoreTeacherByMaster(scoreInfoDto);
//            listScoreResponse.setTotal(total);
//            baseResponse.setData(listScoreResponse);
//            baseResponse.setCode(BaseContants.SUCCESS);
//            return baseResponse;
//        } catch (Exception e) {
//            e.printStackTrace();
//            baseResponse.setCode(BaseContants.ERROR);
//            baseResponse.setMessage(e.getMessage());
//            return baseResponse;
//        }
//    }
//
//    @PostMapping("teacher/score")
//    public BaseResponse listScoreByTeacher(@RequestBody ListScoreRequest scoreInfoDto){
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            ListScoreResponse listScoreResponse = new ListScoreResponse();
//            List<ScoreInfoDTO> scoreInfoDTOList = new ArrayList<ScoreInfoDTO>();
//            List<ScoreInfo> op =  teacherService.listScoreByTeacher(scoreInfoDto);
//            for (ScoreInfo si : op) {
//                ScoreInfoDTO scoreDto = new ScoreInfoDTO();
//                scoreDto.setAvg(si.getAvg());
//                scoreDto.setCourseId(si.getCourseInfo().getCourseId());
//                scoreDto.setCourseName(si.getCourseInfo().getCourseName());
//                scoreDto.setTeacherId(si.getTeacherInfo().getTeacherId());
//                scoreDto.setTeacherName(si.getTeacherInfo().getTeacherName());
//                scoreDto.setMax(si.getMax());
//                scoreDto.setMin(si.getMin());
//                scoreDto.setTerm(si.getTerm());
//                scoreInfoDTOList.add(scoreDto);
//            }
//            listScoreResponse.setScoreInfoList(scoreInfoDTOList);
//            Integer total = teacherService.countScoreByTeacher(scoreInfoDto);
//            listScoreResponse.setTotal(total);
//            baseResponse.setData(listScoreResponse);
//            baseResponse.setCode(BaseContants.SUCCESS);
//            return baseResponse;
//        } catch (Exception e) {
//            e.printStackTrace();
//            baseResponse.setCode(BaseContants.ERROR);
//            baseResponse.setMessage(e.getMessage());
//            return baseResponse;
//        }
//    }
//
//    @PostMapping("student/score")
//    public BaseResponse listScoreByStudent(@RequestBody ListScoreRequest scoreInfoDto){
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            ListScoreResponse listScoreResponse = new ListScoreResponse();
//            List<ScoreInfoDTO> scoreInfoDTOList = new ArrayList<ScoreInfoDTO>();
//            List<ScoreInfo> op =  studentService.listScoreByStudent(scoreInfoDto);
//            for (ScoreInfo si : op) {
//                ScoreInfoDTO scoreDto = new ScoreInfoDTO();
//                scoreDto.setAvg(si.getAvg());
//                scoreDto.setCourseId(si.getCourseInfo().getCourseId());
//                scoreDto.setCourseName(si.getCourseInfo().getCourseName());
//                scoreDto.setStudentId(si.getStudentInfo().getStudentId());
//                scoreDto.setStudentName(si.getStudentInfo().getStudentName());
//                scoreDto.setScore(si.getScore());
//                scoreDto.setTerm(si.getTerm());
//                scoreInfoDTOList.add(scoreDto);
//            }
//            listScoreResponse.setScoreInfoList(scoreInfoDTOList);
//            Integer total = studentService.countScoreByStudent(scoreInfoDto);
//            listScoreResponse.setTotal(total);
//            baseResponse.setData(listScoreResponse);
//            baseResponse.setCode(BaseContants.SUCCESS);
//            return baseResponse;
//        } catch (Exception e) {
//            e.printStackTrace();
//            baseResponse.setCode(BaseContants.ERROR);
//            baseResponse.setMessage(e.getMessage());
//            return baseResponse;
//        }
//    }
//}
