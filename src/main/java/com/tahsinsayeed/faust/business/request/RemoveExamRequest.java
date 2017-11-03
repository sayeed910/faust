package com.tahsinsayeed.faust.business.request;

import com.tahsinsayeed.faust.business.interactor.Request;

/**
 * Created by IMON on 11/3/2017.
 */
public class RemoveExamRequest extends Request {
    public String examId;

    public RemoveExamRequest(String examId) {
        this.examId = examId;
    }
}
