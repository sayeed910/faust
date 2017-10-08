package com.tahsinsayeed.faust.business.entity;

import java.io.File;

public class Note {

    private String title;
    private final File location;

    private Note(String title, File location) {
        this.title = title;
        this.location = location;
    }

    public static Note create(String title, File location) {
        return new Note(title, location);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public File getLocation() {
        return location;
    }
}
