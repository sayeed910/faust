package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.*;

public class AssignmentDto {
    private String id;
    private String courseName;
    private String parentCourseId;
    private String title;
    private String description;

    public AssignmentDto() {
    }

    public AssignmentDto(Assignment assignment, Course course){
        this.courseName = course.getName();
        this.parentCourseId = course.getId();
        this.title = assignment.getTitle();
        this.description = assignment.getDescription();
        this.id = assignment.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentCourseId() {
        return parentCourseId;
    }

    public void setParentCourseId(String parentCourseId) {
        this.parentCourseId = parentCourseId;
    }
}
