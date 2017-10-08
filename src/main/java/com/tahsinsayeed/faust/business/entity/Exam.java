package com.tahsinsayeed.faust.business.entity;

import java.time.*;
import java.util.UUID;

public class Exam {
    private final String examId;
    private final String courseId;
    private final String name;
    private final LocalDate date;
    private final LocalTime time;
    private int totalMark = 0;
    private int receivedMark = 0;

    private Exam(String examId, String courseId, String name, LocalDate examDate, LocalTime examTime) {
        this.examId = examId;
        this.courseId = courseId;
        this.name = name;
        this.date = examDate;
        this.time = examTime;
    }

    public static Exam create(String examName, String parentCourseId, LocalDate examDate, LocalTime examTime){
        return new Exam(UUID.randomUUID().toString(), parentCourseId, examName, examDate, examTime);
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public int getReceivedMark() {
        return receivedMark;
    }

    public void setReceivedMark(int receivedMark) {
        this.receivedMark = receivedMark;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getExamId() {
        return examId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }
}
