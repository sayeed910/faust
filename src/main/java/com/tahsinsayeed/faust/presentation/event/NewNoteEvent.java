package com.tahsinsayeed.faust.presentation.event;

/**
 * Created by sayeed on 11/3/17.
 */
public class NewNoteEvent extends UserEvent {
    public final String parentCourseId;
    public final String title;

    public NewNoteEvent(String parentCourseId, String title) {
        this.parentCourseId = parentCourseId;
        this.title = title;
    }
}
