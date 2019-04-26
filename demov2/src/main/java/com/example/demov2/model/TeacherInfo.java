package com.example.demov2.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/24 8:50
 * @Modified By:
 */
@Entity
@Table(name = "teacher_info")
public class TeacherInfo implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "teacher_id")
    private Integer teacherId;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "teacher_age")
    private Integer teacherAge;

    @Column(name = "teacher_sex")
    private String teacherSex;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }
}
