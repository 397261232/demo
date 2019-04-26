package com.example.demov2.dao;

import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.dto.StudentInfoDTO;
import com.example.demov2.model.ScoreInfo;
import com.example.demov2.model.StudentInfo;

import java.util.List;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/22 15:51
 * @Modified By:
 */
public interface StudentInfoDao {

    /**
     * 根据Id查询学生信息
     * @param id
     * @return
     */
    public StudentInfo getStudentById(Integer id);

    /**
     * 查询学生列表
     * @param studentInfoDto
     * @return
     */
    public List<StudentInfo> listStudent(StudentInfoDTO studentInfoDto);

    /**
     * 查询血学生总数
     * @param studentInfoDto
     * @return
     */
    public Integer countStudentList(StudentInfoDTO studentInfoDto);

    /**
     * 新增学生信息
     * @param studentInfoDto
     */
    public void saveStudent(StudentInfoDTO studentInfoDto);

    /**
     * 学生查询分数
     * @param scoreInfoDto
     * @return
     */
    public List<ScoreInfo> listStudentScore(ListScoreRequest scoreInfoDto);

    /**
     * 查询学生分数总数
     * @param scoreInfoDto
     * @return
     */
    public Integer countStudentScore(ListScoreRequest scoreInfoDto);

    /**
     * 更新学生信息
     * @param studentInfoDto
     */
    public void updateStudent(StudentInfoDTO studentInfoDto);
}
