package com.tahsinsayeed.faust.business.request;

import com.tahsinsayeed.faust.business.interactor.Request;

/**
 * Created by IMON on 11/3/2017.
 */
public class RemoveCourseRequest extends Request {
    public final String id;

    public RemoveCourseRequest(String id) {
        this.id = id;
    }
}
