package com.example.demov2.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/24 10:24
 * @Modified By:
 */
@Entity
@Table(name = "course_info")
public class CourseInfo implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "course_name")
    private String courseName;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
