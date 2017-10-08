package com.tahsinsayeed.faust.business.entity;

import java.time.*;
import java.util.UUID;

public class Exam {
    private final String examId;
    private final String name;
    private final LocalDate date;
    private final LocalTime time;

    private Exam(String examId, String name, LocalDate examDate, LocalTime examTime) {
        this.examId = examId;
        this.name = name;
        this.date = examDate;
        this.time = examTime;
    }

    public static Exam getInstance(String examName, LocalDate examDate, LocalTime examTime){
        return new Exam(UUID.randomUUID().toString(), examName, examDate, examTime);
    }

    public LocalDate getDate() {
        return date;
    }
}
