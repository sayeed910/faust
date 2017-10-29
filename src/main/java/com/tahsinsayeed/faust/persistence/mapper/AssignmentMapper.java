package com.tahsinsayeed.faust.persistence.mapper;

import com.tahsinsayeed.faust.business.entity.Assignment;
import com.tahsinsayeed.faust.persistence.datamodel.AssignmentDataModel;
import com.tahsinsayeed.faust.persistence.repository.DataModelToEntityMapper;

import java.time.LocalDate;

/**
 * Created by sayeed on 10/28/17.
 */
public class AssignmentMapper implements DataModelToEntityMapper<AssignmentDataModel, Assignment> {
    @Override
    public Assignment map(AssignmentDataModel dataModel) {
        return Assignment.withRandomId(dataModel.getParentCourseId(), dataModel.getTitle(),
                dataModel.getDescription(), LocalDate.parse(dataModel.getDueDate()));
    }
}
