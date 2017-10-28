package com.tahsinsayeed.faust.persistence.mapper;

import com.tahsinsayeed.faust.business.entity.Holiday;
import com.tahsinsayeed.faust.persistence.datamodel.HolidayDataModel;

import java.time.LocalDate;

/**
 * Created by sayeed on 10/28/17.
 */
public class HolidayMapper implements DataModelToEntityMapper<HolidayDataModel, Holiday> {
    @Override
    public Holiday map(HolidayDataModel dataModel) {
        return Holiday.withId(dataModel.getId(), LocalDate.parse(dataModel.getDate()), dataModel.getName());
    }
}
