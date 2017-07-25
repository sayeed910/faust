package com.tahsinsayeed.studykit.model;

public class Course {
    private final String id;
    private String name;
    private Attendance attendance;

    public static Course getInstance(String id, String name){
        return new Course(id, name);

    }

    private Course(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return this.name;
    }
}
