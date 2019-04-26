package com.example.demov2.dto.response;

import java.util.List;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/23 15:49
 * @Modified By:
 */
public class StudentInfoListResponse {
    private List<StudentInfoResponse> studentInfoResponseList;
    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<StudentInfoResponse> getStudentInfoResponseList() {
        return studentInfoResponseList;
    }

    public void setStudentInfoResponseList(List<StudentInfoResponse> studentInfoResponseList) {
        this.studentInfoResponseList = studentInfoResponseList;
    }
}
