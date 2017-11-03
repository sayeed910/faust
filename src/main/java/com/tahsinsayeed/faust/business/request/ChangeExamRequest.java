package com.tahsinsayeed.faust.business.request;

import com.tahsinsayeed.faust.business.interactor.Request;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by IMON on 11/3/2017.
 */
public class ChangeExamRequest extends Request {
    public final String examId;
    public final String courseId;
    public final String name;
    public final LocalDate date;
    public final LocalTime time;
    public int totalMark;
    public int receivedMark;

    public ChangeExamRequest(String examId, String courseId, String name, LocalDate date, LocalTime time, int totalMark, int receivedMark) {
        this.examId = examId;
        this.courseId = courseId;
        this.name = name;
        this.date = date;
        this.time = time;
        this.totalMark = totalMark;
        this.receivedMark = receivedMark;
    }
}
