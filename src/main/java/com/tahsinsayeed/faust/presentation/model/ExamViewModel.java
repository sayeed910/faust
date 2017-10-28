        package com.tahsinsayeed.faust.presentation.model;

import com.tahsinsayeed.faust.business.entity.Exam;

import java.time.*;

public class ExamViewModel {
    private String name;
    private double receivedMark;
    private int totalMark;
    private String id;
    private LocalDate examDate;
    private LocalTime examTime;
    private String courseName;
    private String parentCourseId;

    public ExamViewModel() {
    }

    public ExamViewModel(Exam exam, String courseName){
        this.courseName = courseName;
        this.parentCourseId = exam.getCourseId();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCourseId() {
        return parentCourseId;
    }

    public void setParentCourseId(String parentCourseId) {
        this.parentCourseId = parentCourseId;
    }
}
