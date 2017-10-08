package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Assignment;
import com.tahsinsayeed.faust.business.entity.Class;

public class ClassDto {


    private String courseName;

    public ClassDto() {
    }

    public ClassDto(Class clazz, String courseName){
        this.courseName = courseName;
    }


}
