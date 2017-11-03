package com.tahsinsayeed.faust.business.request;

import com.tahsinsayeed.faust.business.interactor.Request;

import java.time.LocalDate;

/**
 * Created by IMON on 11/3/2017.
 */
public class ChangeAssignmentRequest extends Request {
    public final String id;
    public String title;
    public LocalDate dueDate;
    public String description;
    public boolean finished;

    public ChangeAssignmentRequest(String id, String title, LocalDate dueDate, String description, boolean finished) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.description = description;
        this.finished = finished;
    }
}
