package com.tahsinsayeed.faust.presentation.model;

import com.tahsinsayeed.faust.business.dto.ClassDto;
import com.tahsinsayeed.faust.business.entity.Class;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.*;
import java.util.UUID;

public class ClassViewModel {

    private StringProperty id;
    private DayOfWeek classDay;
    private LocalTime classTime;

    public ClassViewModel() {
    }

    public ClassViewModel(ClassDto clazz){
        this.classDay = clazz.classDay;
        this.classTime = clazz.classTime;
        this.id = new SimpleStringProperty(clazz.id);
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

}
