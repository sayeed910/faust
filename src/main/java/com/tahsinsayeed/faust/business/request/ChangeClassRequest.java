package com.tahsinsayeed.faust.business.request;

import com.tahsinsayeed.faust.business.interactor.Request;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Created by IMON on 11/3/2017.
 */

public class ChangeClassRequest extends Request {
    public final String courseId;
    public DayOfWeek day;
    public LocalTime startTime;
    public String id;

    public ChangeClassRequest(String courseId, DayOfWeek day, LocalTime startTime, String id) {
        this.courseId = courseId;
        this.day = day;
        this.startTime = startTime;
        this.id = id;
    }
}
