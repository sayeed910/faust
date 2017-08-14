package com.tahsinsayeed.studykit.model;

public class Exam {
    private final String courseId;
    private final String examId;

    private Exam(String courseId, String examId) {
        this.courseId = courseId;
        this.examId = examId;
    }

    public static Exam getInstance(String courseId, String examId){
        return new Exam(courseId, examId);
    }
}
