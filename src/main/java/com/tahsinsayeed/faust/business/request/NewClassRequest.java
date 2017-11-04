package com.tahsinsayeed.faust.business.request;

import com.tahsinsayeed.faust.business.interactor.Request;

import java.time.*;

/**
 * Created by sayeed on 10/24/17.
 */
public class NewClassRequest extends Request {
    public final String id;
    public final String parentCourseId;
    public final DayOfWeek classDay;
    public final LocalTime classTime;

    public NewClassRequest(String id, String parentCourseId, DayOfWeek classDay, LocalTime classTime) {
        this.id = id;
        this.parentCourseId = parentCourseId;
        this.classDay = classDay;
        this.classTime = classTime;
    }
}
