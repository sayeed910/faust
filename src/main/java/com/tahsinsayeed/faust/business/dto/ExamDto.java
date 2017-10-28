package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Exam;

import java.time.*;

public class ExamDto {
    public final String name;
    public final double receivedMark;
    public final int totalMark;
    public final String id;
    public final LocalDate examDate;
    public final LocalTime examTime;
    public final String parentCourseId;



    private ExamDto(Exam exam){
        this.parentCourseId = exam.getCourseId();
        this.examDate = exam.getDate();
        this.examTime = exam.getTime();
        this.id = exam.getExamId();
        this.name = exam.getName();
        this.totalMark = exam.getTotalMark();
        this.receivedMark = exam.getReceivedMark();
    }

    public static ExamDto from(Exam exam) {
        return new ExamDto(exam);
    }
}
