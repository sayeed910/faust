package com.tahsinsayeed.faust.business.request;

import com.tahsinsayeed.faust.business.interactor.Request;

/**
 * Created by sayeed on 10/24/17.
 */
public class NewCourseRequest extends Request {
    public final String courseId;
    public final String courseName;
    public final String nameOfCourseTeacher;

    public NewCourseRequest(String courseId, String courseName, String nameOfCourseTeacher) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.nameOfCourseTeacher = nameOfCourseTeacher;
    }
}
