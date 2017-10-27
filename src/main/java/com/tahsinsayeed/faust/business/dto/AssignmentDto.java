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

    public AssignmentDto(Assignment assignment,String courseName){
        this.courseName = courseName;
        this.parentCourseId = assignment.getParentCourseId();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssignmentDto that = (AssignmentDto) o;

        if (parentCourseId != null ? !parentCourseId.equals(that.parentCourseId) : that.parentCourseId != null)
            return false;
        return title != null ? title.equals(that.title) : that.title == null;
    }

    @Override
    public int hashCode() {
        int result = parentCourseId != null ? parentCourseId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
