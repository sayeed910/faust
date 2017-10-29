package com.tahsinsayeed.faust.persistence.datamodel;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.tahsinsayeed.faust.business.entity.Assignment;

import java.time.format.DateTimeFormatter;

@DatabaseTable(tableName = "AssignmentDataModel")
public class AssignmentDataModel {

    @DatabaseField(id = true)
    private String id;

    @DatabaseField
    private String parentCourseId;

    @DatabaseField
    private String title;

    @DatabaseField
    private String description;

    @DatabaseField
    private String dueDate;

    @DatabaseField
    private boolean finished;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "course_data_model_id")
    private CourseDataModel courseDataModel;


    public AssignmentDataModel() {
    }

    public AssignmentDataModel(Assignment assignment){
        this.parentCourseId = assignment.getParentCourseId();
        this.title = assignment.getTitle();
        this.description = assignment.getDescription();
        this.id = assignment.getId();
        this.finished = assignment.isFinished();
        this.dueDate = assignment.getDueDate().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

        AssignmentDataModel that = (AssignmentDataModel) o;

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

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
