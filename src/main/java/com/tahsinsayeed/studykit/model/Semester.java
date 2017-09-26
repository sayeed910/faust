package com.tahsinsayeed.studykit.model;

import com.tahsinsayeed.studykit.exception.CourseConflictException;

import java.util.*;

import static com.google.common.base.Preconditions.checkNotNull;

public class Semester {
    private final String id;

    private Date startDate;
    private Date endDate;
    private Map<String, Course> courses;
    private Schedule schedule;

    public static Semester getInstance(String id, Date startDate, Date endDate) {
        return new Semester(id, startDate, endDate);
    }

    private Semester(String id, Date startDate, Date endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courses = new Hashtable<String, Course>();
    }

    public void addCourse(Course course) throws CourseConflictException {
        String courseId = course.getId();

        if (this.courses.containsKey(courseId))
            throw new CourseConflictException("Same semester can not have two courses with same id");

        this.courses.put(courseId, course);
    }

    public void removeCourse(String courseId) {
        this.courses.remove(courseId);
    }

    public Course findCourse(String courseId) {
        return this.courses.get(courseId);
    }

    public String getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date itsStartDate) {
        this.startDate = itsStartDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date itsEndDate) {
        this.endDate = itsEndDate;
    }

    public void addClass(Class clazz){
        schedule.addClass(clazz);
    }
    public void removeClass(Class clazz){
        schedule.removeClass(clazz);
    }
    public void addEvent(Event event){
       schedule.addEvent(event);
    }
    public void removeEvent(Event event){
        schedule.addEvent(event);
    }
    public void addHoliday(Holiday holiday){
        schedule.addHoliday(holiday);
    }
    public void removeHoliday(Holiday holiday){
        schedule.removeHoliday(holiday);
    }
}
