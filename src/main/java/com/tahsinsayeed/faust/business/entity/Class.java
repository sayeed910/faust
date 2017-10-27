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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Class aClass = (Class) o;

        if (courseId != null ? !courseId.equals(aClass.courseId) : aClass.courseId != null) return false;
        if (day != aClass.day) return false;
        return startTime != null ? startTime.equals(aClass.startTime) : aClass.startTime == null;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (day != null ? day.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        return result;
    }
}
