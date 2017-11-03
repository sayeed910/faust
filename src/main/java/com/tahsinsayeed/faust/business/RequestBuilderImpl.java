package com.tahsinsayeed.faust.business;

import com.tahsinsayeed.faust.business.interactor.Request;
import com.tahsinsayeed.faust.business.request.*;
import com.tahsinsayeed.faust.presentation.controller.RequestBuilder;
import com.tahsinsayeed.faust.util.ContentValues;

import java.time.*;


public class RequestBuilderImpl implements RequestBuilder {
    @Override
    public Request make(RequestType type, ContentValues args) {
        switch (type){
            case NEW_COURSE:
                return new NewCourseRequest(
                        args.get("courseId"),
                        args.get("courseName"),
                        "");
            case NEW_ASSIGNMENT:
                return new NewAssignmentRequest(
                        args.get("assignmentTitle"),
                        args.get("courseId"),
                        LocalDate.parse(args.get("dueDate")),
                        args.get("description"));
            case NEW_EXAM:
                return new NewExamRequest(
                        args.get("examName"),
                        args.get("courseId"),
                        LocalDate.parse(args.get("examDate")),
                        LocalTime.parse(args.get("examTime"))
                );
            case NEW_BOOK:
                return new NewBookRequest(
                        args.get("courseId"),
                        args.get("bookName"),
                        args.get("filePath")
                );
            case NEW_CLASS:
                return new NewClassRequest(
                        args.get("courseId"),
                        DayOfWeek.valueOf(args.get("nameOfDay")),
                        LocalTime.parse(args.get("startTime"))
                );
            case NEW_NOTE:
                return new NewNoteRequest(
                        args.get("id"),
                        args.get("title"),
                        args.get("content"),
                        args.get("courseId")
                );
            case EDIT_NOTE:
                return new ChangeNoteRequest(
                        args.get("id"),
                        args.get("title"),
                        args.get("content")
                );

            default: throw new UnsupportedOperationException();
        }
    }
}
