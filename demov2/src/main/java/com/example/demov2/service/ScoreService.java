package com.example.demov2.service;

import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.model.ScoreInfo;

import java.util.List;

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
    List<ScoreInfo> listScoreAllByMaster(ListScoreRequest scoreInfoDto);

    /**
     * 查询教导主任查询分数总数
     * @param scoreInfoDto
     * @return
     */
    Integer countScoreAllByMaster(ListScoreRequest scoreInfoDto);

    /**
     * 教导主任查询教师分数
     * @param scoreInfoDto
     * @return
     */
    List<ScoreInfo> listScoreTeacherByMaster(ListScoreRequest scoreInfoDto);

    /**
     * 教导主任查询教师分数总数
     * @param scoreInfoDto
     * @return
     */
    Integer countScoreTeacherByMaster(ListScoreRequest scoreInfoDto);


}
