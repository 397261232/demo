package com.example.demov2.service.impl;

import com.example.demov2.dao.StudentInfoDao;
import com.example.demov2.dto.*;
import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.dto.response.ListScoreResponse;
import com.example.demov2.dto.response.StudentInfoListResponse;
import com.example.demov2.dto.response.StudentInfoResponse;
import com.example.demov2.model.ScoreInfo;
import com.example.demov2.model.StudentInfo;
import com.example.demov2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/23 15:00
 * @Modified By:
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentInfoDao studentInfoDao;


    @Override
    public StudentInfoResponse getStudentById(Integer id) {
        StudentInfo op =  studentInfoDao.getStudentById(id);
        StudentInfoResponse studentInfoResponse = new StudentInfoResponse();
        studentInfoResponse.setStudentAge(op.getStudentAge());
        studentInfoResponse.setStudentId(op.getStudentId());
        studentInfoResponse.setStudentName(op.getStudentName());
        if ("1".equals(op.getStudentSex())) {
            studentInfoResponse.setStudentSex("男");
        }else if ("0".equals(op.getStudentSex())) {
            studentInfoResponse.setStudentSex("女");
        }
        return studentInfoResponse;
    }

    @Override
    public StudentInfoListResponse listStudent(StudentInfoDTO studentInfoDto) {
        StudentInfoListResponse studentInfoListResponse = new StudentInfoListResponse();
        List<StudentInfoResponse> studentInfoResponseList = new ArrayList<>();
        List<StudentInfo> studentInfoList = studentInfoDao.listStudent(studentInfoDto);
        for(StudentInfo si : studentInfoList){
            StudentInfoResponse studentInfo = new StudentInfoResponse();
            studentInfo.setStudentId(si.getStudentId());
            studentInfo.setStudentAge(si.getStudentAge());
            studentInfo.setStudentName(si.getStudentName());
            if ("1".equals(si.getStudentSex())) {
                studentInfo.setStudentSex("男");
            }else if ("0".equals(si.getStudentSex())) {
                studentInfo.setStudentSex("女");
            }
            studentInfoResponseList.add(studentInfo);
        }
        Integer total = studentInfoDao.countStudentList(studentInfoDto);
        studentInfoListResponse.setStudentInfoResponseList(studentInfoResponseList);
        studentInfoListResponse.setTotal(String.valueOf(total));
        return studentInfoListResponse;
    }

    @Override
    public void saveStudent(StudentInfoDTO studentInfoDto) {
        studentInfoDao.saveStudent(studentInfoDto);
    }

    @Override
    public void updateStudent(StudentInfoDTO studentInfoDto) {
        studentInfoDao.updateStudent(studentInfoDto);
    }

    @Override
    public ListScoreResponse listScoreByStudent(ListScoreRequest scoreInfoDto) {
        ListScoreResponse listScoreResponse = new ListScoreResponse();
        List<ScoreInfoDTO> scoreInfoDTOList = new ArrayList<ScoreInfoDTO>();
        List<ScoreInfo> scoreInfoList = studentInfoDao.listStudentScore(scoreInfoDto);
        for (ScoreInfo si : scoreInfoList) {
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
        Integer total = studentInfoDao.countStudentScore(scoreInfoDto);
        listScoreResponse.setScoreInfoList(scoreInfoDTOList);
        listScoreResponse.setTotal(total);
        return listScoreResponse;
    }


}
