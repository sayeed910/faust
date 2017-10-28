package com.tahsinsayeed.faust.presentation.model;

import com.tahsinsayeed.faust.business.dto.NoteDto;
import com.tahsinsayeed.faust.business.entity.Note;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by sayeed on 10/25/17.
 */
public class NoteViewModel {
    private SimpleStringProperty id;
    private StringProperty title;
    private StringProperty parentCourseId;
    private StringProperty filePath;

    public NoteViewModel() {
    }

    public NoteViewModel(NoteDto note){
        this.title = new SimpleStringProperty(note.title);
        this.parentCourseId = new SimpleStringProperty(note.parentCourseId);
        this.id = new SimpleStringProperty(note.id);
        this.filePath = new SimpleStringProperty(note.filePath);
    }

    public SimpleStringProperty getId() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public StringProperty getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty getParentCourseId() {
        return parentCourseId;
    }

    public void setParentCourseId(String parentCourseId) {
        this.parentCourseId.set(parentCourseId);
    }

    public StringProperty getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath.set(filePath);
    }
}
