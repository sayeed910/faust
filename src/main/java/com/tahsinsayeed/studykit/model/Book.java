package com.tahsinsayeed.studykit.model;

public class Book {
    private String name;
    private String path;

    private Book(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public static Book create(String name, String path) {
        return new Book(name, path);
    }
}
