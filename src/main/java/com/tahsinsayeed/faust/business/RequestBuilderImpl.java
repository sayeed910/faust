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
                        args.get("teachersName"));
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
                        args.get("id"),
                        args.get("courseId"),
                        DayOfWeek.valueOf(args.get("nameOfDay")),
                        LocalTime.parse(args.get("startTime"))
                );
            case NEW_HOLIDAY:
                return new NewHolidayRequest(
                        LocalDate.parse(args.get("dueDate")),
                        args.get("holidayName"),
                        args.get("id")
                );
            case NEW_NOTE:
                return new NewNoteRequest(
                        args.get("id"),
                        args.get("title"),
                        args.get("content"),
                        args.get("courseId")
                );
            case EDIT_ASSIGNMENT:
                return new ChangeAssignmentRequest(
                        args.get("id"),
                        args.get("assignmentTitle"),
                        LocalDate.parse(args.get("dueDate")),
                        args.get("description"),
                        Boolean.valueOf(args.get("finished"))
                );
            case EDIT_CLASS:
                return new ChangeClassRequest(
                        args.get("courseId"),
                        DayOfWeek.valueOf(args.get("nameOfDay")),
                        LocalTime.parse(args.get("startTime")),
                        args.get("id")
                );
            case EDIT_COURSE:
                return new ChangeCourseRequest(

                        args.get("courseId"),
                        args.get("courseName")
                );
            case EDIT_EXAM:
                return new ChangeExamRequest(
                        args.get("examId"),
                        args.get("courseId"),
                        args.get("name"),
                        LocalDate.parse(args.get("examDate")),
                        LocalTime.parse(args.get("examTime")),
                        Integer.parseInt(args.get("totalMark")),
                        Integer.parseInt(args.get("receivedMark"))
                );
            case EDIT_HOLIDAY:
                return new ChangeHolidayRequest(
                        LocalDate.parse(args.get("dueDate")),
                        args.get("holidayName"),
                        args.get("id")
                );
            case EDIT_NOTE:
                return new ChangeNoteRequest(
                        args.get("id"),
                        args.get("title"),
                        args.get("content")
                );
            case REMOVE_ASSIGNMENT:
                return new RemoveAssignmentRequest(
                  args.get("id")
                );
            case REMOVE_BOOK:
                return new RemoveBookRequest(
                  args.get("name")
                );
            case REMOVE_CLASS:
                return new RemoveClassRequest(
                  args.get("courseId")
                );
            case REMOVE_COURSE:
                return new RemoveCourseRequest(
                        args.get("id")
                );
            case REMOVE_EXAM:
                return new RemoveExamRequest(
                  args.get("examId")
                );
            case REMOVE_HOLIDAY:
                return new RemoveHolidayRequest(
                        args.get("id")
                );
            case REMOVE_NOTE:
                return new RemoveNoteRequest(
                  args.get("id")
                );

            default: throw new UnsupportedOperationException();
        }
    }
}
