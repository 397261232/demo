package com.example.demov2.controller;

import com.example.demov2.constant.BaseContants;
import com.example.demov2.dto.*;
import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.dto.response.BaseResponse;
import com.example.demov2.dto.response.ListScoreResponse;
import com.example.demov2.dto.response.StudentInfoListResponse;
import com.example.demov2.dto.response.StudentInfoResponse;
import com.example.demov2.service.ScoreService;
import com.example.demov2.service.StudentService;
import com.example.demov2.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/23 14:21
 * @Modified By:
 */
@RestController
@RequestMapping("school")
public class SchoolController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private TeacherService teacherService;


    @PostMapping(value="student/id")
    public BaseResponse getStudentById(HttpServletRequest request ){
        BaseResponse baseResponse = new BaseResponse();
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            StudentInfoResponse op =  studentService.getStudentById(id);
            baseResponse.setData(op);
            baseResponse.setCode(BaseContants.SUCCESS);
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setCode(BaseContants.ERROR);
            baseResponse.setMessage(e.getMessage());
            return baseResponse;
        }
    }

    @PostMapping(value="student/list")
    public BaseResponse listStudent(@RequestBody StudentInfoDTO studentInfoDto){
        BaseResponse baseResponse = new BaseResponse();
        try {
            StudentInfoListResponse op =  studentService.listStudent(studentInfoDto);
            baseResponse.setData(op);
            baseResponse.setCode(BaseContants.SUCCESS);
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setCode(BaseContants.ERROR);
            baseResponse.setMessage(e.getMessage());
            return baseResponse;
        }
    }

    @PostMapping(value="student/save")
    public BaseResponse saveStudent(@RequestBody StudentInfoDTO studentInfoDto){
        BaseResponse baseResponse = new BaseResponse();
        StudentInfoDTO existStudent = new StudentInfoDTO();
        try {
            existStudent.setStudentId(studentInfoDto.getStudentId());
            String total = studentService.listStudent(existStudent).getTotal();
            if (!"0".equals(total)) {
                baseResponse.setCode(BaseContants.ERROR);
                baseResponse.setMessage("学号重复");
                return baseResponse;
            }
            studentService.saveStudent(studentInfoDto);
            baseResponse.setCode(BaseContants.SUCCESS);
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setCode(BaseContants.ERROR);
            baseResponse.setMessage(e.getMessage());
            return baseResponse;
        }
    }

    @PostMapping(value="student/update")
    public BaseResponse updateStudent(@RequestBody StudentInfoDTO studentInfoDto){
        BaseResponse baseResponse = new BaseResponse();
        StudentInfoDTO existStudent = new StudentInfoDTO();
        try {
            if (!StringUtils.isEmpty(studentInfoDto.getStudentId())) {
                existStudent.setStudentId(studentInfoDto.getStudentId());
                List<StudentInfoResponse> studentInfoListResponse= studentService.listStudent(existStudent).getStudentInfoResponseList();
                StudentInfoResponse op =  studentService.getStudentById(studentInfoDto.getId());
                if (!CollectionUtils.isEmpty(studentInfoListResponse)&&!op.getStudentId().equals(studentInfoDto.getStudentId())){
                        baseResponse.setCode(BaseContants.ERROR);
                        baseResponse.setMessage("学号重复");
                        return baseResponse;
                }
            }
            studentService.updateStudent(studentInfoDto);
            baseResponse.setCode(BaseContants.SUCCESS);
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setCode(BaseContants.ERROR);
            baseResponse.setMessage(e.getMessage());
            return baseResponse;
        }
    }

    @PostMapping("master/score")
    public BaseResponse listScoreMaster(@RequestBody ListScoreRequest scoreInfoDto){
        BaseResponse baseResponse = new BaseResponse();
        try {
            ListScoreResponse op =  scoreService.listScoreAllByMaster(scoreInfoDto);
            baseResponse.setData(op);
            baseResponse.setCode(BaseContants.SUCCESS);
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setCode(BaseContants.ERROR);
            baseResponse.setMessage(e.getMessage());
            return baseResponse;
        }
    }

    @PostMapping("master/teacher/score")
    public BaseResponse listScoreTeacher(@RequestBody ListScoreRequest scoreInfoDto){
        BaseResponse baseResponse = new BaseResponse();
        try {
            ListScoreResponse op =  scoreService.listScoreTeacherByMaster(scoreInfoDto);
            baseResponse.setData(op);
            baseResponse.setCode(BaseContants.SUCCESS);
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setCode(BaseContants.ERROR);
            baseResponse.setMessage(e.getMessage());
            return baseResponse;
        }
    }

    @PostMapping("teacher/score")
    public BaseResponse listScoreByTeacher(@RequestBody ListScoreRequest scoreInfoDto){
        BaseResponse baseResponse = new BaseResponse();
        try {
            ListScoreResponse op =  teacherService.listScoreByTeacher(scoreInfoDto);
            baseResponse.setData(op);
            baseResponse.setCode(BaseContants.SUCCESS);
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setCode(BaseContants.ERROR);
            baseResponse.setMessage(e.getMessage());
            return baseResponse;
        }
    }

    @PostMapping("student/score")
    public BaseResponse listScoreByStudent(@RequestBody ListScoreRequest scoreInfoDto){
        BaseResponse baseResponse = new BaseResponse();
        try {
            ListScoreResponse op =  studentService.listScoreByStudent(scoreInfoDto);
            baseResponse.setData(op);
            baseResponse.setCode(BaseContants.SUCCESS);
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setCode(BaseContants.ERROR);
            baseResponse.setMessage(e.getMessage());
            return baseResponse;
        }
    }
}
