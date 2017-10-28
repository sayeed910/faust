package com.tahsinsayeed.faust.persistence.datamodel;

import com.tahsinsayeed.faust.business.dto.ExamDto;

import java.time.format.DateTimeFormatter;

public class ExamDataModel {
    private String name;
    private double receivedMark;
    private int totalMark;
    private String id;
    private String examDate;
    private String examTime;
    private String courseName;
    private String parentCourseId;

    public ExamDataModel() {
    }

    public ExamDataModel(ExamDto exam){
        this.parentCourseId = exam.parentCourseId;
        this.examDate = exam.examDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        this.examTime = exam.examTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
        this.id = exam.id;
        this.name = exam.name;
        this.totalMark = exam.totalMark;
        this.receivedMark = exam.receivedMark;
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

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
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
