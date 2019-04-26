package com.example.demov2.service;

import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.dto.response.ListScoreResponse;

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
    ListScoreResponse listScoreByTeacher(ListScoreRequest scoreInfoDto);
}
