package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Holiday;

import java.time.LocalDate;

/**
 * Created by sayeed on 10/25/17.
 */
public class HolidayDto {
    public final String id;
    public final String name;
    public final LocalDate date;



    private HolidayDto(Holiday holiday){
        this.id = holiday.getId();
        this.name = holiday.getHolidayName();
        this.date = holiday.getDate();
    }

    public static HolidayDto from(Holiday holiday) {
        return new HolidayDto(holiday);
    }
}
