package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Note;

import java.io.*;
import java.nio.file.Files;

/**
 * Created by sayeed on 10/25/17.
 */
public class NoteDto {
    public final String id;
    public final String title;
    public final String parentCourseId;
    public final String content;



    private NoteDto(Note note){
        this.title = note.getTitle();
        this.parentCourseId = note.getParentCourseId();
        this.id = note.getId();
        File file = note.getFile();
        this.content = readContents(file);
    }

    private String readContents(File file) {
        try {
            Files.readAllLines(file.toPath()).get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static NoteDto from(Note note) {
        return new NoteDto(note);
    }
}
