package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.Holiday;
import com.tahsinsayeed.faust.business.request.ChangeHolidayRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;

/**
 * Created by IMON on 11/3/2017.
 */
public class ChangeHolidayInteractor implements Interactor {
    private final Repository<Holiday> holidayRepository;

    public ChangeHolidayInteractor(Repository<Holiday> holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Override
    public void execute(Request request) {
        ChangeHolidayRequest holidayRequest = (ChangeHolidayRequest) request;
        Holiday holiday = holidayRepository.get(holidayRequest.id);

        holiday.setHolidayName(holidayRequest.holidayName);

        holidayRepository.update(holiday);

    }
}
