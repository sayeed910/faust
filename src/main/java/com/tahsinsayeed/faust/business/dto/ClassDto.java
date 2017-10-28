package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Class;

import java.time.*;

public class ClassDto {

    public final String id;
    public final DayOfWeek classDay;
    public final LocalTime classTime;
    public final String parentCourseId;


    private ClassDto(Class clazz){
        this.classDay = clazz.getDay();
        this.classTime = clazz.getStartTime();
        this.id = clazz.getId();
        this.parentCourseId = clazz.getCourseId();
    }

    public static ClassDto from(Class clazz) {
        return new ClassDto(clazz);
    }
}
