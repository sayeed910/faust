package com.tahsinsayeed.faust.business.request;

import com.tahsinsayeed.faust.business.interactor.Request;

import java.time.*;

/**
 * Created by sayeed on 10/24/17.
 */
public class NewExamRequest extends Request {
    public final String title;
    public final String parentCourseId;
    public final LocalDate examDate;
    public final LocalTime examTime;

    public NewExamRequest(String title, String parentCourseId, LocalDate examDate, LocalTime examTime) {
        this.title = title;
        this.parentCourseId = parentCourseId;
        this.examDate = examDate;
        this.examTime = examTime;
    }
}
