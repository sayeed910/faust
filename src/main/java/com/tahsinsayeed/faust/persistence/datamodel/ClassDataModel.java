package com.tahsinsayeed.faust.persistence.datamodel;

import com.tahsinsayeed.faust.business.dto.ClassDto;

import java.time.format.DateTimeFormatter;

public class ClassDataModel {

    private String id;
    private int classDay;
    private String classTime;
    private String courseName;

    public ClassDataModel() {
    }

    public ClassDataModel(ClassDto clazz){
        this.classDay = clazz.classDay.getValue();
        this.classTime = clazz.classTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
        this.id = clazz.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getClassDay() {
        return classDay;
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
