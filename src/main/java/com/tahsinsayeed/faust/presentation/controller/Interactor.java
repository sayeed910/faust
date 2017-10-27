package com.tahsinsayeed.faust.presentation.controller;

import com.tahsinsayeed.faust.business.interactor.Request;

public interface Interactor {
    void execute(Request request);

    public class CourseNotFound extends RuntimeException {
    }
}
