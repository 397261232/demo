package com.example.demov2.service.impl;

import com.example.demov2.dao.TeacherDao;
import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.dto.response.ListScoreResponse;
import com.example.demov2.dto.ScoreInfoDTO;
import com.example.demov2.model.ScoreInfo;
import com.example.demov2.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public ListScoreResponse listScoreByTeacher(ListScoreRequest scoreInfoDto) {
        ListScoreResponse listScoreResponse = new ListScoreResponse();
        List<ScoreInfoDTO> scoreInfoDTOList = new ArrayList<ScoreInfoDTO>();
        List<ScoreInfo> scoreInfoList = teacherDao.listScoreByTeacher(scoreInfoDto);
        for (ScoreInfo si : scoreInfoList) {
            ScoreInfoDTO scoreDto = new ScoreInfoDTO();
            scoreDto.setAvg(si.getAvg());
            scoreDto.setCourseId(si.getCourseInfo().getCourseId());
            scoreDto.setCourseName(si.getCourseInfo().getCourseName());
            scoreDto.setTeacherId(si.getTeacherInfo().getTeacherId());
            scoreDto.setTeacherName(si.getTeacherInfo().getTeacherName());
            scoreDto.setMax(si.getMax());
            scoreDto.setMin(si.getMin());
            scoreDto.setTerm(si.getTerm());
            scoreInfoDTOList.add(scoreDto);
        }
        Integer total = teacherDao.countScoreByTeacher(scoreInfoDto);
        listScoreResponse.setScoreInfoList(scoreInfoDTOList);
        listScoreResponse.setTotal(total);
        return listScoreResponse;
    }
}
