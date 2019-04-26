package com.example.demov2.dao;

import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.model.ScoreInfo;

import java.util.List;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/24 10:35
 * @Modified By:
 */
public interface ScoreInfoDao {

    /**
     *教导主任根据学期查询分数
     * @param scoreInfoDto
     * @return
     */
    public List<ScoreInfo> listTermScoreByMaster(ListScoreRequest scoreInfoDto);

    /**
     *查询教导主任学期分数总数
     * @param scoreInfoDto
     * @return
     */
    public Integer countTermScoreByMaster(ListScoreRequest scoreInfoDto);

    /**
     * 教导主任查询教师分数信息
     * @param scoreInfoDto
     * @return
     */
    public List<ScoreInfo> listScoreTeacher(ListScoreRequest scoreInfoDto);

    /**
     * 查询教导主任查询教师分数信息总数
     * @param scoreInfoDto
     * @return
     */
    public Integer countScoreTeacher(ListScoreRequest scoreInfoDto);
}
