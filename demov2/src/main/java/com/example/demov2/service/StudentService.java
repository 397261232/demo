package com.example.demov2.service;

import com.example.demov2.dto.*;
import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.dto.response.ListScoreResponse;
import com.example.demov2.dto.response.StudentInfoListResponse;
import com.example.demov2.dto.response.StudentInfoResponse;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/23 15:00
 * @Modified By:
 */
public interface StudentService {

    /**
     * id查询学生信息
     * @param id
     * @return
     */
    StudentInfoResponse getStudentById(Integer id);

    /**
     * 根据条件查询学生列表
     * @param studentInfoDto
     * @return
     */
    StudentInfoListResponse listStudent(StudentInfoDTO studentInfoDto);

    /**
     * 新增学生信息
     * @param studentInfoDto
     */
    void saveStudent(StudentInfoDTO studentInfoDto);

    /**
     * 学生查询成绩信息
     * @param scoreInfoDto
     * @return
     */
    ListScoreResponse listScoreByStudent(ListScoreRequest scoreInfoDto);

    /**
     * 新增学生信息
     * @param studentInfoDto
     */
    void updateStudent(StudentInfoDTO studentInfoDto);
}
