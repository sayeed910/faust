package com.tahsinsayeed.faust.business.interactor;

import com.google.inject.Inject;
import com.tahsinsayeed.faust.business.dto.HolidayDto;
import com.tahsinsayeed.faust.business.entity.Holiday;
import com.tahsinsayeed.faust.business.request.NewHolidayRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;
import com.tahsinsayeed.faust.presentation.model.ViewModelStorage;

/**
 * Created by IMON on 11/3/2017.
 */
public class AddHolidayInteractor implements Interactor {
    private final Repository<Holiday> holidayRepository;

    @Inject
    public AddHolidayInteractor(Repository<Holiday> holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Override
    public void execute(Request request){
        NewHolidayRequest holidayRequest = (NewHolidayRequest) request;

        Holiday holiday = Holiday.create(holidayRequest.date, holidayRequest.holidayName);
        holidayRepository.save(holiday);
        HolidayDto holidayDto = HolidayDto.from(holiday);
        ViewModelStorage.getInstance().add(holidayDto);
    }
}
