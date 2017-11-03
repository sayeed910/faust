package com.tahsinsayeed.faust.business.request;

import com.tahsinsayeed.faust.business.entity.Assignment;
import com.tahsinsayeed.faust.business.entity.Book;
import com.tahsinsayeed.faust.business.entity.Exam;
import com.tahsinsayeed.faust.business.entity.Note;
import com.tahsinsayeed.faust.business.interactor.Request;

import java.util.List;

/**
 * Created by IMON on 11/3/2017.
 */
public class ChangeCourseRequest extends Request {
    public String id;
    public String name;

    public ChangeCourseRequest(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
