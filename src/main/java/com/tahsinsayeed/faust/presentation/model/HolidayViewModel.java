        package com.tahsinsayeed.faust.presentation.model;

import com.tahsinsayeed.faust.business.dto.HolidayDto;
import com.tahsinsayeed.faust.business.entity.Holiday;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 * Created by sayeed on 10/25/17.
 */
public class HolidayViewModel {
    private StringProperty name;
    private LocalDate date;

    public HolidayViewModel(){

    }

    public HolidayViewModel(HolidayDto holiday){
        this.name = new SimpleStringProperty(holiday.name);
        this.date = holiday.date;
    }

    public StringProperty getName() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date =date;
    }
}
