package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Exam;

import java.time.*;
import java.util.UUID;

public class ExamDto {
    private String name;
    private double receivedMark;
    private int totalMark;
    private String id;
    private LocalDate examDate;
    private LocalTime examTime;
    private String courseName;

    public ExamDto() {
    }

    public ExamDto(Exam exam, String courseName){
        this.courseName = courseName;
        this.examDate = exam.getDate();
        this.examTime = exam.getTime();
        this.id = exam.getExamId();
        this.name = exam.getName();
        this.totalMark = exam.getTotalMark();
        this.receivedMark = exam.getReceivedMark();
    }

    public double getReceivedMark() {
        return receivedMark;
    }

    public void setReceivedMark(double receivedMark) {
        this.receivedMark = receivedMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public LocalTime getExamTime() {
        return examTime;
    }

    public void setExamTime(LocalTime examTime) {
        this.examTime = examTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
