package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Note;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

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
           List<String> lines = Files.readAllLines(file.toPath());
            if (lines.size() > 0) return lines.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static NoteDto from(Note note) {
        return new NoteDto(note);
    }
}
