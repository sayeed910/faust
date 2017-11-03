package com.tahsinsayeed.faust.presentation.event;

/**
 * Created by sayeed on 11/3/17.
 */
public class EditNoteEvent extends UserEvent {
    public final String parentCourseId;
    public final String title;
    public final String content;
    public final String id;

    public EditNoteEvent(String parentCourseId, String title, String content, String id) {
        this.parentCourseId = parentCourseId;
        this.title = title;
        this.content = content;
        this.id = id;
    }
}
