package com.tahsinsayeed.faust.persistence.mapper;

import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.persistence.datamodel.ClassDataModel;

import java.time.*;

/**
 * Created by sayeed on 10/28/17.
 */
public class ClassMapper implements DataModelToEntityMapper<ClassDataModel, Class> {
    @Override
    public Class map(ClassDataModel dataModel) {
        return Class.create(dataModel.getParentCourseId(), DayOfWeek.of(dataModel.getClassDay()),
                LocalTime.parse(dataModel.getClassTime()));
    }
}
