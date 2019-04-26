package com.example.demov2.dto.response;

import com.example.demov2.dto.ScoreInfoDTO;

import java.util.List;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/24 11:29
 * @Modified By:
 */
public class ListScoreResponse {

    private List<ScoreInfoDTO> ScoreInfoList;

    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<ScoreInfoDTO> getScoreInfoList() {
        return ScoreInfoList;
    }

    public void setScoreInfoList(List<ScoreInfoDTO> scoreInfoList) {
        ScoreInfoList = scoreInfoList;
    }
}
