package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.Holiday;
import com.tahsinsayeed.faust.business.entity.Holiday;
import com.tahsinsayeed.faust.business.request.RemoveHolidayRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;

/**
 * Created by IMON on 11/3/2017.
 */
public class RemoveHolidayInteractor implements Interactor {
    private final Repository<Holiday> holidayRepository;

    public RemoveHolidayInteractor(Repository<Holiday> holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Override
    public void execute(Request request) {
        RemoveHolidayRequest holidayRequest = (RemoveHolidayRequest) request;

        Holiday holiday = holidayRepository.get(holidayRequest.id);
        holidayRepository.delete(holiday);

    }
}