package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Assignment;

public class AssignmentDto {
    public String id;
    public String courseName;
    public String title;
    public String description;

    public AssignmentDto() {
    }

    public AssignmentDto(Assignment assignment, String courseName){
        this.courseName = courseName;
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
}
