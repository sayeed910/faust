package com.tahsinsayeed.faust.presentation.event;

/**
 * Created by sayeed on 11/3/17.
 */
public class SaveNoteEvent extends UserEvent {
    public final String id;
    public final String parentCourseId;
    public final String title;
    public final String content;

    public SaveNoteEvent(String id, String parentCourseId, String title, String content) {
        this.id = id;
        this.parentCourseId = parentCourseId;
        this.title = title;
        this.content = content;
    }
}
