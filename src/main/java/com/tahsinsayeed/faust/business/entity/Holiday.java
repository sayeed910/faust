package com.tahsinsayeed.faust.business.entity;

import java.util.Date;

import static java.util.Objects.requireNonNull;

public class Holiday {
    private final Date date;
    private String holidayName;

    public static Holiday createEvent(Date date, String event){
        final Date date1 = requireNonNull(date, "Date of a holiday can not be null");
        final String event1 = requireNonNull(event, "For null holiday the other constructor should be used");

        return new Holiday(date1, event1);
    }

    public static Holiday createEvent(Date date){
        final Date date1 = requireNonNull(date, "Date of an holidayName can not be null");

        return new Holiday(date1, "");
    }

    protected Holiday(Date date, String holidayName) {
        this.date = date;
        this.holidayName = holidayName;
    }

    public Date getDate() {
        return date;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }
}
