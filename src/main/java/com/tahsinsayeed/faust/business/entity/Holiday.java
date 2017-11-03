package com.tahsinsayeed.faust.business.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Holiday {
    private final LocalDate date;
    private String holidayName;
    private final String id;

    public static Holiday create(LocalDate date, String name){
          return new Holiday(date, name);
    }



    public static Holiday withId(String id, LocalDate date, String name){
        return new Holiday(date, name);
    }



    private Holiday(LocalDate date, String holidayName) {
        this.date = date;
        this.holidayName = holidayName;
        this.id = UUID.randomUUID().toString();
    }

    public LocalDate getDate() {
        return date;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName){
        this.holidayName = holidayName;
    }

    public String getId() {
        return id;
    }


}
