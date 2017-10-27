package com.tahsinsayeed.faust.business;

import com.tahsinsayeed.faust.business.interactor.Request;
import com.tahsinsayeed.faust.business.request.NewCourseRequest;
import com.tahsinsayeed.faust.presentation.controller.RequestBuilder;
import com.tahsinsayeed.faust.util.ContentValues;

/**
 * Created by sayeed on 10/26/17.
 */
public class RequestBuilderImpl implements RequestBuilder {
    @Override
    public Request make(RequestType type, ContentValues args) {
        switch (type){
            case NEW_COURSE:
                return new NewCourseRequest(
                        args.get("courseId"),
                        args.get("courseName"),
                        "");
            default: throw new UnsupportedOperationException();
        }
    }
}
