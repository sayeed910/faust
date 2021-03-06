package com.tahsinsayeed.faust.business.entity;

import javafx.stage.FileChooser;

import java.io.File;

public class Book {
    private String name;
    private String parentCourseId;
    private File file;

    private Book(String name, String parentCourseId, File file) {
        this.name = name;
        this.parentCourseId = parentCourseId;
        this.file = file;

//        FileChooser
    }

    public static Book create(String name, String parentCourseId, File file) {
        return new Book(name,parentCourseId, file);
    }

    public String getName() {
        return name;
    }

    public String getParentCourseId() {
        return parentCourseId;
    }

    public File getFile() {
        return file;
    }
}
