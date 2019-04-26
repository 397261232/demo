package com.example.demov2.dao;

import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.model.ScoreInfo;

import java.util.List;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/25 9:16
 * @Modified By:
 */
public interface TeacherDao {

    /**
     * 教师查询分数
     * @param scoreInfoDto
     * @return
     */
    public List<ScoreInfo>  listScoreByTeacher(ListScoreRequest scoreInfoDto);

    /**
     * 查询教师分数总数
     * @param scoreInfoDto
     * @return
     */
    public Integer countScoreByTeacher(ListScoreRequest scoreInfoDto);
}
