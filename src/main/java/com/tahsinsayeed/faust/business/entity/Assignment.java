package com.tahsinsayeed.faust.business.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Assignment {

    private final String id;
    private final String title;
    private LocalDate dueDate;
    private String description;
    private String parentCourseId;

    private Assignment(String parentCourseId, String title, String description, LocalDate dueDate) {
        this.parentCourseId = parentCourseId;
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.dueDate = dueDate;
        this.description = description;
    }

    public static Assignment create(String parentCourseId,String title, LocalDate dueDate) {
        return create(parentCourseId, title,"", dueDate);
    }


    public static Assignment create(String parentCourseId, String title, String description, LocalDate dueDate) {
        return new Assignment(parentCourseId, title, description, dueDate);
    }

    public LocalDate getDate() {
        return dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getParentCourseId() {
        return parentCourseId;
    }
}
