package com.example.demov2.service;

import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.dto.response.ListScoreResponse;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/24 16:06
 * @Modified By:
 */
public interface ScoreService {

    /**
     * 教导主任查询分数
     * @param scoreInfoDto
     * @return
     */
    ListScoreResponse listScoreAllByMaster(ListScoreRequest scoreInfoDto);

    /**
     * 教导主任查询教师分数
     * @param scoreInfoDto
     * @return
     */
    ListScoreResponse listScoreTeacherByMaster(ListScoreRequest scoreInfoDto);


}
