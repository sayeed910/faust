package com.tahsinsayeed.faust.presentation.model;

import com.tahsinsayeed.faust.business.dto.AssignmentDto;
import javafx.beans.property.*;

public class AssignmentViewModel {
    private StringProperty id;
    private StringProperty parentCourseId;
    private StringProperty title;
    private StringProperty description;



    public AssignmentViewModel(AssignmentDto assignment){
        this.parentCourseId = new SimpleStringProperty(assignment.parentCourseId);
        this.title = new SimpleStringProperty(assignment.title);
        this.description = new SimpleStringProperty(assignment.description);
        this.id = new SimpleStringProperty(assignment.id);
    }

    public StringProperty getId() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
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

        AssignmentViewModel that = (AssignmentViewModel) o;

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
