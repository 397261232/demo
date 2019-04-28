package com.example.demov2.service.impl;

import com.example.demov2.dao.TeacherDao;
import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.model.ScoreInfo;
import com.example.demov2.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/25 9:01
 * @Modified By:
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;


    @Override
    public List<ScoreInfo> listScoreByTeacher(ListScoreRequest scoreInfoDto) {
        List<ScoreInfo> scoreInfoList = teacherDao.listScoreByTeacher(scoreInfoDto);
        return scoreInfoList;
    }

    /**
     * 教师查询分数信息总数
     *
     * @param scoreInfoDto
     * @return
     */
    @Override
    public Integer countScoreByTeacher(ListScoreRequest scoreInfoDto) {
        Integer total = teacherDao.countScoreByTeacher(scoreInfoDto);
        return total;
    }
}
