package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Note;

/**
 * Created by sayeed on 10/25/17.
 */
public class NoteDto {
    public final String id;
    public final String title;
    public final String parentCourseId;
    public final String filePath;



    private NoteDto(Note note){
        this.title = note.getTitle();
        this.parentCourseId = note.getParentCourseId();
        this.id = note.getId();
        this.filePath = note.getFile().getAbsolutePath();
    }

    public static NoteDto from(Note note) {
        return new NoteDto(note);
    }
}
