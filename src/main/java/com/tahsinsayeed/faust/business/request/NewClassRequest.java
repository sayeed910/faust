package com.tahsinsayeed.faust.business.request;

import com.tahsinsayeed.faust.business.interactor.Request;

import java.time.*;

/**
 * Created by sayeed on 10/24/17.
 */
public class NewClassRequest extends Request {
    public final String parentCourseId;
    public final DayOfWeek classDay;
    public final LocalTime classTime;

    public NewClassRequest(String parentCourseId, DayOfWeek classDay, LocalTime classTime) {
        this.parentCourseId = parentCourseId;
        this.classDay = classDay;
        this.classTime = classTime;
    }
}
