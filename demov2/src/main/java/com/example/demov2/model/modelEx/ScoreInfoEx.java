package com.example.demov2.model.modelEx;

import com.example.demov2.model.ScoreInfo;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/24 10:36
 * @Modified By:
 */
public class ScoreInfoEx  {
    private double avg;
    private double max;
    private double min;
    private String courseName;



    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }
}
