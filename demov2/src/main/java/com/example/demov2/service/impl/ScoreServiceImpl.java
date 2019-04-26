package com.example.demov2.service.impl;

import com.example.demov2.dao.ScoreInfoDao;
import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.dto.response.ListScoreResponse;
import com.example.demov2.dto.ScoreInfoDTO;
import com.example.demov2.model.ScoreInfo;
import com.example.demov2.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public ListScoreResponse listScoreAllByMaster(ListScoreRequest scoreInfoDtoRequest) {
        ListScoreResponse listScoreResponse = new ListScoreResponse();
        List<ScoreInfoDTO> scoreInfoDTOList = new ArrayList<ScoreInfoDTO>();
        List<ScoreInfo> scoreInfoExList = scoreInfoDao.listTermScoreByMaster(scoreInfoDtoRequest);
        for (ScoreInfo si : scoreInfoExList) {
            ScoreInfoDTO scoreInfoDto = new ScoreInfoDTO();
            scoreInfoDto.setAvg(si.getAvg());
            scoreInfoDto.setCourseId(si.getCourseInfo().getCourseId());
            scoreInfoDto.setCourseName(si.getCourseInfo().getCourseName());
            scoreInfoDto.setMax(si.getMax());
            scoreInfoDto.setMin(si.getMin());
            scoreInfoDto.setTerm(si.getTerm());
            scoreInfoDTOList.add(scoreInfoDto);
        }
        Integer total = scoreInfoDao.countTermScoreByMaster(scoreInfoDtoRequest);
        listScoreResponse.setScoreInfoList(scoreInfoDTOList);
        listScoreResponse.setTotal(total);
        return listScoreResponse;
    }

    @Override
    public ListScoreResponse listScoreTeacherByMaster(ListScoreRequest scoreInfoDto) {
        ListScoreResponse listScoreResponse = new ListScoreResponse();
        List<ScoreInfoDTO> scoreInfoDTOList = new ArrayList<ScoreInfoDTO>();
        List<ScoreInfo> scoreInfoList = scoreInfoDao.listScoreTeacher(scoreInfoDto);
        for (ScoreInfo si : scoreInfoList) {
            ScoreInfoDTO scoreDto = new ScoreInfoDTO();
            scoreDto.setAvg(si.getAvg());
            scoreDto.setCourseId(si.getCourseInfo().getCourseId());
            scoreDto.setCourseName(si.getCourseInfo().getCourseName());
            scoreDto.setTeacherId(si.getTeacherInfo().getTeacherId());
            scoreDto.setTeacherName(si.getTeacherInfo().getTeacherName());
            scoreDto.setMax(si.getMax());
            scoreDto.setMin(si.getMin());
            scoreInfoDTOList.add(scoreDto);
        }
        Integer total = scoreInfoDao.countScoreTeacher(scoreInfoDto);
        listScoreResponse.setScoreInfoList(scoreInfoDTOList);
        listScoreResponse.setTotal(total);
        return listScoreResponse;
    }

}
