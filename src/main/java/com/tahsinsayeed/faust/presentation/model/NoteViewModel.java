package com.tahsinsayeed.faust.presentation.model;

import com.tahsinsayeed.faust.business.dto.NoteDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by sayeed on 10/25/17.
 */
public class NoteViewModel {
    private SimpleStringProperty id;
    private StringProperty title;
    private StringProperty parentCourseId;
    private StringProperty content;

    public NoteViewModel() {
        id = new SimpleStringProperty();
        title = new SimpleStringProperty();
        parentCourseId = new SimpleStringProperty();
        content = new SimpleStringProperty();
    }

    public NoteViewModel(NoteDto note){
        this.title = new SimpleStringProperty(note.title);
        this.parentCourseId = new SimpleStringProperty(note.parentCourseId);
        this.id = new SimpleStringProperty(note.id);
        this.content = new SimpleStringProperty(note.content);
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

    public StringProperty getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content.set(content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteViewModel that = (NoteViewModel) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
