package com.tahsinsayeed.faust.business.entity;

import java.time.LocalDate;
import java.util.*;

import static com.google.common.base.Preconditions.checkNotNull;

public class Semester {
    private final String id;

    private LocalDate startDate;
    private LocalDate endDate;
    private Map<String, Course> courses;
    private Schedule schedule;

    public static Semester getInstance(String id, LocalDate startDate, LocalDate endDate) {
        return new Semester(id, startDate, endDate);
    }

    private Semester(String id, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courses = new Hashtable<>();
        this.schedule = Schedule.create();
    }

    public void addCourse(Course course) throws CourseConflict {
        String courseId = course.getId();

        if (this.courses.containsKey(courseId))
            throw new CourseConflict();

        this.courses.put(courseId, course);
    }

    public void removeCourse(String courseId) {
        this.courses.remove(courseId);
    }

    public Course findCourseById(String courseId) {
        return this.courses.get(courseId);
    }

    public String getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate itsStartDate) {
        this.startDate = itsStartDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate itsEndDate) {
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

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses.values());
    }


    public class CourseConflict extends Exception {

    }
}
