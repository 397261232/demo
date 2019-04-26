package com.example.demov2.controller;

import com.example.demov2.constant.BaseContants;
import com.example.demov2.dto.ScoreInfoDTO;
import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.dto.response.BaseResponse;
import com.example.demov2.dto.response.ListScoreResponse;
import com.example.demov2.model.ScoreInfo;
import com.example.demov2.service.ScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/26 15:47
 * @Modified By:
 */
@RestController
@RequestMapping("score")
public class ScoreInfoController {

    @Autowired
    private ScoreService scoreService;

    static private Logger logger = LoggerFactory.getLogger(Object.class);

    @PostMapping("master/term")
    public BaseResponse listScoreMaster(@RequestBody ListScoreRequest scoreInfoRequest) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            ListScoreResponse listScoreResponse = new ListScoreResponse();
            List<ScoreInfoDTO> scoreInfoDTOList = new ArrayList<ScoreInfoDTO>();
            List<ScoreInfo> op = scoreService.listScoreAllByMaster(scoreInfoRequest);
            for (ScoreInfo si : op) {
                ScoreInfoDTO scoreInfoDto = new ScoreInfoDTO();
                scoreInfoDto.setAvg(si.getAvg());
                scoreInfoDto.setCourseId(si.getCourseInfo().getCourseId());
                scoreInfoDto.setCourseName(si.getCourseInfo().getCourseName());
                scoreInfoDto.setMax(si.getMax());
                scoreInfoDto.setMin(si.getMin());
                scoreInfoDto.setTerm(si.getTerm());
                scoreInfoDTOList.add(scoreInfoDto);
            }
            listScoreResponse.setScoreInfoList(scoreInfoDTOList);
            Integer total = scoreService.countScoreAllByMaster(scoreInfoRequest);
            listScoreResponse.setTotal(total);
            baseResponse.setData(listScoreResponse);
            baseResponse.setCode(BaseContants.SUCCESS_CODE);
            baseResponse.setMessage(BaseContants.SUCCESS_MESSAGE);
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse.setCode(BaseContants.ERROR_CODE);
            logger.error(e.getMessage());
            baseResponse.setMessage(BaseContants.ERROR_MESSAGE + e.getMessage());
            return baseResponse;
        }
    }

    @PostMapping("master/teacher")
    public BaseResponse listScoreTeacher(@RequestBody ListScoreRequest scoreInfoDto) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            ListScoreResponse listScoreResponse = new ListScoreResponse();
            List<ScoreInfoDTO> scoreInfoDTOList = new ArrayList<ScoreInfoDTO>();
            List<ScoreInfo> op = scoreService.listScoreTeacherByMaster(scoreInfoDto);
            for (ScoreInfo si : op) {
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
            listScoreResponse.setScoreInfoList(scoreInfoDTOList);
            Integer total = scoreService.countScoreTeacherByMaster(scoreInfoDto);
            listScoreResponse.setTotal(total);
            baseResponse.setData(listScoreResponse);
            baseResponse.setCode(BaseContants.SUCCESS_CODE);
            baseResponse.setMessage(BaseContants.SUCCESS_MESSAGE);
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            baseResponse.setCode(BaseContants.ERROR_CODE);
            baseResponse.setMessage(BaseContants.ERROR_MESSAGE + e.getMessage());
            return baseResponse;
        }
    }
}
