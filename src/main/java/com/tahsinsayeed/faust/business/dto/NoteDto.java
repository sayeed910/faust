package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Note;

/**
 * Created by sayeed on 10/25/17.
 */
public class NoteDto {
    private String id;
    private String title;
    private String parentCourseId;
    private String filePath;

    public NoteDto() {
    }

    public NoteDto(Note note){
        this.title = note.getTitle();
        this.parentCourseId = note.getParentCourseId();
        this.id = note.getId();
        this.filePath = note.getFile().getAbsolutePath();
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
