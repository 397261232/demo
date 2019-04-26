package com.example.demov2.dto.request;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/24 14:34
 * @Modified By:
 */
public class ListScoreRequest {
    private Integer term;
    private Integer teacherId;
    private Integer studentId;
    private Integer pageNo;
    private Integer pageSize;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
