        package com.tahsinsayeed.faust.presentation.model;

import com.tahsinsayeed.faust.business.entity.Holiday;

import java.time.LocalDate;

/**
 * Created by sayeed on 10/25/17.
 */
public class HolidayViewModel {
    private String name;
    private LocalDate date;

    public HolidayViewModel(){

    }

    public HolidayViewModel(Holiday holiday){
        this.name = holiday.getHolidayName();
        this.date = holiday.getDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
