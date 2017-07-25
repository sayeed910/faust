package com.tahsinsayeed.studykit.exception;

public class CourseConflictException extends Exception {
    public CourseConflictException(){
        super();
    }

    public CourseConflictException(String message){
        super(message);
    }
}
