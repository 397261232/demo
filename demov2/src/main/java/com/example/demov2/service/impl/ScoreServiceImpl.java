package com.example.demov2.service.impl;

import com.example.demov2.dao.ScoreInfoDao;
import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.model.ScoreInfo;
import com.example.demov2.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/24 16:06
 * @Modified By:
 */
@Service
public class ScoreServiceImpl  implements ScoreService {

    @Autowired
    private ScoreInfoDao scoreInfoDao;

    @Override
    public List<ScoreInfo> listScoreAllByMaster(ListScoreRequest scoreInfoDtoRequest) {
        List<ScoreInfo> scoreInfoExList = scoreInfoDao.listTermScoreByMaster(scoreInfoDtoRequest);
        return scoreInfoExList;
    }

    /**
     * 查询教导主任查询分数总数
     *
     * @param scoreInfoDto
     * @return
     */
    @Override
    public Integer countScoreAllByMaster(ListScoreRequest scoreInfoDto) {
        Integer total = scoreInfoDao.countTermScoreByMaster(scoreInfoDto);
        return total;
    }

    @Override
    public List<ScoreInfo> listScoreTeacherByMaster(ListScoreRequest scoreInfoDto) {
        List<ScoreInfo> scoreInfoList = scoreInfoDao.listScoreTeacher(scoreInfoDto);
        return scoreInfoList;
    }

    /**
     * 教导主任查询教师分数总数
     *
     * @param scoreInfoDto
     * @return
     */
    @Override
    public Integer countScoreTeacherByMaster(ListScoreRequest scoreInfoDto) {
        Integer total = scoreInfoDao.countScoreTeacher(scoreInfoDto);
        return total;
    }

}
