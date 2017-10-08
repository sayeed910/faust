package com.tahsinsayeed.faust.business.entity;

import java.time.*;

public class Class {
    private final String courseId;
    private DayOfWeek day;
    private LocalTime startTime;

    public Class(String courseId, DayOfWeek day, LocalTime startTime) {
        this.courseId = courseId;

        this.day = day;
        this.startTime = startTime;
    }

    public static Class create(String courseId, DayOfWeek day, LocalTime startTime) {
        return new Class(courseId, day, startTime);
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public String getCourseId() {
        return courseId;
    }
}
