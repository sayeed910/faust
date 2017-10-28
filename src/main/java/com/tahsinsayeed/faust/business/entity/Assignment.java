package com.tahsinsayeed.faust.business.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Assignment {

    private final String id;
    private final String parentCourseId;
    private String title;
    private LocalDate dueDate;
    private String description;
    private boolean finished;

    private Assignment(String id, String parentCourseId, String title, String description, LocalDate dueDate) {
        this.parentCourseId = parentCourseId;
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.description = description;
        this.finished = false;
    }

    public static Assignment withRandomId(String parentCourseId, String title, String description, LocalDate dueDate) {
        return withId(UUID.randomUUID().toString(), parentCourseId, title,description, dueDate);
    }


    public static Assignment withId(String id, String parentCourseId, String title, String description, LocalDate dueDate) {
        return new Assignment(id, parentCourseId, title, description, dueDate);
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getParentCourseId() {
        return parentCourseId;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }


}
