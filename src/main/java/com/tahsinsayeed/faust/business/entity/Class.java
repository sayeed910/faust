package com.tahsinsayeed.faust.business.entity;

import java.time.*;

public class Class {
    private Course course;
    private DayOfWeek day;
    private LocalTime startTime;

    public Class(Course course, DayOfWeek day, LocalTime startTime) {
        this.course = course;

        this.day = day;
        this.startTime = startTime;
    }

    public static Class create(Course course, DayOfWeek day, LocalTime startTime) {
        return new Class(course, day, startTime);
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
