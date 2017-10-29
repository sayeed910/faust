package com.tahsinsayeed.faust.persistence.mapper;

import com.tahsinsayeed.faust.business.entity.Exam;
import com.tahsinsayeed.faust.persistence.datamodel.ExamDataModel;
import com.tahsinsayeed.faust.persistence.repository.DataModelToEntityMapper;

import java.time.*;

/**
 * Created by sayeed on 10/28/17.
 */
public class ExamMapper implements DataModelToEntityMapper<ExamDataModel, Exam> {
    @Override
    public Exam map(ExamDataModel dataModel) {
        return Exam.withId(dataModel.getId(), dataModel.getName(), dataModel.getParentCourseId(),
                LocalDate.parse(dataModel.getExamDate()), LocalTime.parse(dataModel.getExamTime()));
    }
}
