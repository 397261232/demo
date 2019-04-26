package com.example.demov2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/24 10:26
 * @Modified By:
 */
@Entity
@Table(name = "score_info")
public class ScoreInfo implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "score_id")
    private Integer scoreId;

    @ManyToOne
    @JoinColumn(name="student_id",referencedColumnName="student_id")
    private StudentInfo studentInfo;

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    @ManyToOne
    @JoinColumn(name="course_id",referencedColumnName="course_id")
    private CourseInfo courseInfo;

    @ManyToOne
    @JoinColumn(name="teacher_id",referencedColumnName="teacher_id")
    private TeacherInfo teacherInfo;

    @Column(name="score")
    private Double score;

    @Column(name="term")
    private Integer term;

    @Transient
    private Double avg;

    @Transient
    private Double max;

    @Transient
    private Double min;

    @Transient
    private String courseName;

    @Transient
    private String teacherName;

    public CourseInfo getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(CourseInfo courseInfo) {
        this.courseInfo = courseInfo;
    }

    public TeacherInfo getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(TeacherInfo teacherInfo) {
        this.teacherInfo = teacherInfo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public  ScoreInfo(){

    }

}
