package com.tahsinsayeed.faust.business.request;

import com.tahsinsayeed.faust.business.interactor.Request;

import java.time.LocalDate;

/**
 * Created by IMON on 11/3/2017.
 */
public class ChangeHolidayRequest extends Request {
    public final LocalDate date;
    public String holidayName;
    public final String id;

    public ChangeHolidayRequest(LocalDate date, String holidayName, String id) {
        this.date = date;
        this.holidayName = holidayName;
        this.id = id;
    }
}
