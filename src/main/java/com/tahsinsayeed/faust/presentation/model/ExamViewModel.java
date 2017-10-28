        package com.tahsinsayeed.faust.presentation.model;

import com.j256.ormlite.stmt.query.In;
import com.tahsinsayeed.faust.business.dto.ExamDto;
import com.tahsinsayeed.faust.business.entity.Exam;
import com.tahsinsayeed.faust.persistence.datamodel.ExamDataModel;
import javafx.beans.property.*;

import java.time.*;

public class ExamViewModel {
    private StringProperty name;
    private DoubleProperty receivedMark;
    private IntegerProperty totalMark;
    private SimpleStringProperty id;
    private LocalDate examDate;
    private LocalTime examTime;
    private StringProperty parentCourseId;

    public ExamViewModel() {
    }

    public ExamViewModel(ExamDto exam){
        this.name=new SimpleStringProperty(exam.name);
        this.parentCourseId = new SimpleStringProperty(exam.parentCourseId);
        this.examDate = exam.examDate;
        this.examTime = exam.examTime;
        this.id = new SimpleStringProperty(exam.id);
        this.totalMark =new  SimpleIntegerProperty(exam.totalMark);
        this.receivedMark = new  SimpleDoubleProperty(exam.receivedMark);
    }

    public DoubleProperty getReceivedMark() {
        return receivedMark;
    }

    public void setReceivedMark(double receivedMark) {
        this.receivedMark.setValue(receivedMark);
    }

    public IntegerProperty getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark.setValue(totalMark);
    }

    public SimpleStringProperty getId() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
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

    public StringProperty getName() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty getParentCourseId() {
        return parentCourseId;
    }

    public void setParentCourseId(String parentCourseId) {
        this.parentCourseId.set(parentCourseId);
    }
}
