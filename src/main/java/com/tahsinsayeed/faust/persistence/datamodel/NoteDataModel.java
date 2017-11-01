package com.tahsinsayeed.faust.persistence.datamodel;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.tahsinsayeed.faust.business.entity.Note;

/**
 * Created by sayeed on 10/25/17.
 */

@DatabaseTable(tableName = "NoteDataModel")
public class NoteDataModel {

    @DatabaseField(id = true)
    private String id;

    @DatabaseField
    private String title;

    @DatabaseField
    private String parentCourseId;

    @DatabaseField
    private String filePath;

    @DatabaseField(foreign = true, foreignAutoRefresh = false, columnName="course_id")
    private CourseDataModel courseDataModel;

    public NoteDataModel() {
    }

    public NoteDataModel(Note note){
        this.title = note.getTitle();
        this.parentCourseId = note.getParentCourseId();
        this.id = note.getId();
        this.filePath = note.getFile().getAbsolutePath();
        this.courseDataModel = new CourseDataModel();
        this.courseDataModel.setId(parentCourseId);
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

    public String getParentCourseId() {
        return parentCourseId;
    }

    public void setParentCourseId(String parentCourseId) {
        this.parentCourseId = parentCourseId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
