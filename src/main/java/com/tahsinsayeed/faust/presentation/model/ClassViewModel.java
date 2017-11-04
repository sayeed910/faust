package com.tahsinsayeed.faust.presentation.model;

import com.tahsinsayeed.faust.business.dto.ClassDto;
import javafx.beans.property.*;

import java.time.*;

public class ClassViewModel {
    private StringProperty parentCourseId;
    private StringProperty id;
    private DayOfWeek classDay;
    private LocalTime classTime;

    public ClassViewModel() {
    }

    public ClassViewModel(ClassDto clazz){

        this.classDay = clazz.classDay;
        this.classTime = clazz.classTime;
        this.id = new SimpleStringProperty(clazz.id);
        this.parentCourseId = new SimpleStringProperty(clazz.parentCourseId);
    }

    public StringProperty  getId() {
        return id;
    }

    public void setId(String  id) {
        this.id.set(id);
    }

    public DayOfWeek getClassDay() {
        return classDay;
    }

    public void setClassDay(DayOfWeek classDay) {
        this.classDay = classDay;
    }

    public LocalTime getClassTime() {
        return classTime;
    }

    public void setClassTime(LocalTime classTime) {
        this.classTime = classTime;
    }

    public String getParentCourseId() {
        return parentCourseId.get();
    }

    public StringProperty parentCourseIdProperty() {
        return parentCourseId;
    }

    public void setParentCourseId(String parentCourseId) {
        this.parentCourseId.set(parentCourseId);
    }
}
