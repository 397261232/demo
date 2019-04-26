package com.example.demov2.controller;

import com.example.demov2.constant.BaseContants;
import com.example.demov2.dto.ScoreInfoDTO;
import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.dto.response.BaseResponse;
import com.example.demov2.dto.response.ListScoreResponse;
import com.example.demov2.model.ScoreInfo;
import com.example.demov2.service.TeacherService;
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
 * @Date:Create: 2019/4/26 15:48
 * @Modified By:
 */
@RestController
@RequestMapping("teacher")
public class TeacherInfoController {

    @Autowired
    private TeacherService teacherService;

    static private Logger logger = LoggerFactory.getLogger(Object.class);

    @PostMapping("score")
    public BaseResponse listScoreByTeacher(@RequestBody ListScoreRequest scoreInfoDto) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            ListScoreResponse listScoreResponse = new ListScoreResponse();
            List<ScoreInfoDTO> scoreInfoDTOList = new ArrayList<ScoreInfoDTO>();
            List<ScoreInfo> op = teacherService.listScoreByTeacher(scoreInfoDto);
            for (ScoreInfo si : op) {
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
            listScoreResponse.setScoreInfoList(scoreInfoDTOList);
            Integer total = teacherService.countScoreByTeacher(scoreInfoDto);
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
