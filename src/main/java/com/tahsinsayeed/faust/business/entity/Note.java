package com.tahsinsayeed.faust.business.entity;

import java.io.File;
import java.util.UUID;

public class Note {
    private final String id;
    private final String parentCourseId;
    private String title;
    private final File location;

    private Note(String id, String parentCourseId, String title, File location) {
        this.id = id;
        this.parentCourseId = parentCourseId;
        this.title = title;
        this.location = location;
    }

    public static Note create(String title, String parentCourseId, File location) {
        return new Note(UUID.randomUUID().toString(), parentCourseId, title, location);
    }


    public static Note withId(String id, String title, String parentCourseId, File location) {
        return new Note(id, parentCourseId, title, location);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public File getFile() {
        return location;
    }

    public String getId() {
        return id;
    }

    public String getParentCourseId() {
        return parentCourseId;
    }
}
