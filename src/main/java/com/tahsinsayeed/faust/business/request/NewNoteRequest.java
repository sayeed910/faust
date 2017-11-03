package com.tahsinsayeed.faust.business.request;

import com.tahsinsayeed.faust.business.interactor.Request;

/**
 * Created by sayeed on 11/3/17.
 */
public class NewNoteRequest extends Request {
    public final String id;
    public final String title;
    public final String content;
    public final String courseId;

    public NewNoteRequest(String id, String title, String content, String courseId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.courseId = courseId;
    }
}
