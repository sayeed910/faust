package com.tahsinsayeed.studykit.business.entity;

import java.time.LocalDate;

public class Assignment {


    private final String title;
    private LocalDate dueDate;
    private String description;

    private Assignment(String title, String description, LocalDate dueDate) {

        this.title = title;
        this.dueDate = dueDate;
        this.description = description;
    }

    public static Assignment create(String title, LocalDate dueDate) {
        return createWithDescription(title,"", dueDate);
    }


    public static Assignment createWithDescription(String title, String description, LocalDate dueDate) {
        return new Assignment(title, description, dueDate);
    }

    public LocalDate getDate() {
        return dueDate;
    }
}
