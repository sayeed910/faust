package com.tahsinsayeed.faust.business.request;

import com.tahsinsayeed.faust.business.interactor.Request;

import java.time.LocalDate;

/**
 * Created by sayeed on 10/24/17.
 */
public class NewAssignmentRequest extends Request {
    public final String title;
    public final String parentCourseId;
    public final LocalDate dateOfSubmission;
    public final String description;

    public NewAssignmentRequest(String title, String parentCourseId, LocalDate dateOfSubmission, String description) {
        this.title = title;
        this.parentCourseId = parentCourseId;
        this.dateOfSubmission = dateOfSubmission;
        this.description = description;
    }
}
