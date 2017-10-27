package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Assignment;
import com.tahsinsayeed.faust.business.entity.Class;

import java.time.*;
import java.util.UUID;

public class ClassDto {

    private String id;
    private DayOfWeek classDay;
    private LocalTime classTime;
    private String courseName;

    public ClassDto() {
    }

    public ClassDto(Class clazz, String courseName){
        this.courseName = courseName;
        this.classDay = clazz.getDay();
        this.classTime = clazz.getStartTime();
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DayOfWeek getClassDay() {
        return classDay;
    }

    public void setClassDay(DayOfWeek classDay) {
        this.classDay = classDay;
    }

    public LocalTime getClassTime() {
        return classTime;
    }

    public void setClassTime(LocalTime classTime) {
        this.classTime = classTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
