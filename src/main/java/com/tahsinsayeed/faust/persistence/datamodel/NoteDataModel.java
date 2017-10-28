package com.tahsinsayeed.faust.persistence.datamodel;

import com.tahsinsayeed.faust.business.dto.NoteDto;

/**
 * Created by sayeed on 10/25/17.
 */
public class NoteDataModel {
    private String id;
    private String title;
    private String parentCourseId;
    private String filePath;

    public NoteDataModel() {
    }

    public NoteDataModel(NoteDto note){
        this.title = note.title;
        this.parentCourseId = note.parentCourseId;
        this.id = note.id;
        this.filePath = note.filePath;
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
