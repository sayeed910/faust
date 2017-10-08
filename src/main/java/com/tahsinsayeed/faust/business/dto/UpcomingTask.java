package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Exam;

import java.util.List;

public class UpcomingTask {
    public List<ClassDto> upcomingClasses;
    public List<AssignmentDto> upcomingAssignments;
    public List<ExamDto> upcomingExams;

    public UpcomingTask(List<ClassDto> upcomingClasses, List<AssignmentDto> upcomingAssignments, List<ExamDto> upcomingExams) {
        this.upcomingClasses = upcomingClasses;
        this.upcomingAssignments = upcomingAssignments;
        this.upcomingExams = upcomingExams;
    }

}
