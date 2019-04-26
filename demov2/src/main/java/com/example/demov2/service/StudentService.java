package com.example.demov2.service;

import com.example.demov2.dto.StudentInfoDTO;
import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.model.ScoreInfo;
import com.example.demov2.model.StudentInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/23 15:00
 * @Modified By:
 */
@Transactional
public interface StudentService {

    /**
     * id查询学生信息
     * @param id
     * @return
     */
    StudentInfo getStudentById(Integer id);

    /**
     * 根据条件查询学生列表
     * @param studentInfoDto
     * @return
     */
    List<StudentInfo> listStudent(StudentInfoDTO studentInfoDto);

    /**
     * 根据条件查询学生列表总数
     * @param studentInfoDto
     * @return
     */
    Integer countStudentList(StudentInfoDTO studentInfoDto);

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
    List<ScoreInfo> listScoreByStudent(ListScoreRequest scoreInfoDto);

    /**
     * 学生查询成绩信息总数
     * @param scoreInfoDto
     * @return
     */
    Integer countScoreByStudent(ListScoreRequest scoreInfoDto);

    /**
     * 新增学生信息
     * @param studentInfoDto
     */
    void updateStudent(StudentInfoDTO studentInfoDto);
}
