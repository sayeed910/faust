package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Exam;
import javafx.collections.*;

import java.util.*;
import java.util.stream.Collectors;

public class UpcomingTask {
    private ObservableList<ClassDto> upcomingClasses;
    private ObservableList<AssignmentDto> upcomingAssignments;
    private ObservableList<ExamDto> upcomingExams;

    public UpcomingTask(List<ClassDto> upcomingClasses,
                        List<AssignmentDto> upcomingAssignments, List<ExamDto> upcomingExams) {
        this.upcomingClasses = FXCollections.observableArrayList(upcomingClasses);
        this.upcomingAssignments = FXCollections.observableArrayList(upcomingAssignments);
        this.upcomingExams = FXCollections.observableArrayList(upcomingExams);
    }

    public UpcomingTask() {
        this(FXCollections.observableArrayList(), FXCollections.observableArrayList(), FXCollections.observableArrayList());
    }

    public ObservableList<ClassDto> getUpcomingClasses() {
        return upcomingClasses;
    }

    public void setUpcomingClasses(List<ClassDto> upcomingClasses) {
        this.upcomingClasses.clear();
        this.upcomingClasses.addAll(upcomingClasses);
    }

    public ObservableList<AssignmentDto> getUpcomingAssignments() {
        return upcomingAssignments;
    }

    public void setUpcomingAssignments(List<AssignmentDto> upcomingAssignments) {
        this.upcomingAssignments.clear();
        this.upcomingAssignments.addAll(upcomingAssignments);
    }

    public ObservableList<ExamDto> getUpcomingExams() {
        return upcomingExams;
    }

    public void setUpcomingExams(List<ExamDto> upcomingExams) {
        this.upcomingExams.clear();
        this.upcomingExams.addAll(upcomingExams);
    }

    public ObservableList<String> getList(){
        List<String> exams =  upcomingExams.stream().map(e->e.getName()).collect(Collectors.toList());
        List<String> assignments =  upcomingAssignments.stream().map(e->e.getTitle()).collect(Collectors.toList());
        List<String> classes =  upcomingExams.stream().map(e->e.getName()).collect(Collectors.toList());

        List<String> items = new ArrayList<>(exams);
        items.addAll(assignments);
        items.addAll(classes);



        return FXCollections.observableArrayList(items);

    }
}
