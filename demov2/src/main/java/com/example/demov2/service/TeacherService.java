package com.example.demov2.service;

import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.model.ScoreInfo;

import java.util.List;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/25 8:58
 * @Modified By:
 */
public interface TeacherService {

    /**
     * 教师查询分数信息
     * @param scoreInfoDto
     * @return
     */
    List<ScoreInfo> listScoreByTeacher(ListScoreRequest scoreInfoDto);

    /**
     * 教师查询分数信息总数
     * @param scoreInfoDto
     * @return
     */
    Integer countScoreByTeacher(ListScoreRequest scoreInfoDto);
}
