package com.tahsinsayeed.faust.business.entity;

import java.time.LocalDate;

public class Holiday {
    private final LocalDate date;
    private final String holidayName;

    public static Holiday create(LocalDate date, String name){
          return new Holiday(date, name);
    }

    public static Holiday createWithNoName(LocalDate date){
        return new Holiday(date, "");
    }

    private Holiday(LocalDate date, String holidayName) {
        this.date = date;
        this.holidayName = holidayName;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getHolidayName() {
        return holidayName;
    }


}
