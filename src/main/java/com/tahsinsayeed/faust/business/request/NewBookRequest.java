package com.tahsinsayeed.faust.business.request;

import com.tahsinsayeed.faust.business.interactor.Request;

/**
 * Created by sayeed on 10/24/17.
 */
public class NewBookRequest extends Request {
    public final String parentCourseId;
    public final String name;
    public final String filePath;

    public NewBookRequest(String parentCourseId, String name, String filePath) {
        this.parentCourseId = parentCourseId;
        this.name = name;
        this.filePath = filePath;
    }
}
