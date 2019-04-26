package com.example.demov2.dto.response;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/23 14:57
 * @Modified By:
 */
public class StudentInfoResponse {

    private Integer studentId;
    private String studentName;
    private Integer studentAge;
    private String studentSex;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }
}
