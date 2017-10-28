package com.tahsinsayeed.faust.persistence.datamodel;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.tahsinsayeed.faust.business.dto.ClassDto;

import java.time.format.DateTimeFormatter;

@DatabaseTable(tableName = "ClassDataModel")
public class ClassDataModel {

    @DatabaseField(id = true)
    private String id;

    @DatabaseField
    private int classDay;

    @DatabaseField
    private String classTime;

    @DatabaseField
    private String parentCourseId;

    public ClassDataModel() {
    }

    public ClassDataModel(ClassDto clazz){
        this.classDay = clazz.classDay.getValue();
        this.classTime = clazz.classTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
        this.id = clazz.id;
        this.parentCourseId = clazz.parentCourseId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getClassDay() {
        return classDay;
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getParentCourseId() {
        return parentCourseId;
    }

    public void setParentCourseId(String parentCourseId) {
        this.parentCourseId = parentCourseId;
    }
}
