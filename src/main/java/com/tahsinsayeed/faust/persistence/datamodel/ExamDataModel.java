package com.tahsinsayeed.faust.persistence.datamodel;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.tahsinsayeed.faust.business.entity.Exam;
import com.tahsinsayeed.faust.persistence.repository.CourseRepository;

import java.time.format.DateTimeFormatter;

@DatabaseTable(tableName = "ExamDataModel")
public class ExamDataModel {
    @DatabaseField
    private String name;
    @DatabaseField
    private double receivedMark;
    @DatabaseField
    private int totalMark;

    @DatabaseField(id = true)
    private String id;


    @DatabaseField
    private String examDate;

    @DatabaseField
    private String examTime;

    @DatabaseField
    private String courseName;

    @DatabaseField
    private String parentCourseId;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName="course_id")
    private CourseDataModel courseDataModel;

    public ExamDataModel() {
    }

    public ExamDataModel(Exam exam){
        this.parentCourseId = exam.getCourseId();
        this.examDate = exam.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE);
        this.examTime = exam.getTime().format(DateTimeFormatter.ISO_LOCAL_TIME);
        this.id = exam.getExamId();
        this.name = exam.getName();
        this.totalMark = exam.getTotalMark();
        this.receivedMark = exam.getReceivedMark();
        this.courseDataModel = new CourseDataModel(new CourseRepository().get(parentCourseId));
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

    public CourseDataModel getCourseDataModel() {
        return courseDataModel;
    }

    public void setCourseDataModel(CourseDataModel courseDataModel) {
        this.courseDataModel = courseDataModel;
    }
}
