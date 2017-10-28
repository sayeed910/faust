package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.entity.Class;

import java.util.List;
import java.util.stream.Collectors;

public class UpcomingTasks {
    public final List<ClassDto> upcomingClasses;
    public final List<AssignmentDto> upcomingAssignments;
    public final List<ExamDto> upcomingExams;

    private UpcomingTasks(List<Class> upcomingClasses,
                          List<Assignment> upcomingAssignments, List<Exam> upcomingExams) {
        this.upcomingClasses = upcomingClasses.stream().map(ClassDto::from).collect(Collectors.toList());
        this.upcomingAssignments = upcomingAssignments.stream().map(AssignmentDto::from).collect(Collectors.toList());
        this.upcomingExams = upcomingExams.stream().map(ExamDto::from).collect(Collectors.toList());;
    }

    public static UpcomingTasks from(List<Class> upcomingClasses,
                                     List<Assignment> upcomingAssignments, List<Exam> upcomingExams) {
        return new UpcomingTasks(upcomingClasses, upcomingAssignments, upcomingExams);
    }
}
