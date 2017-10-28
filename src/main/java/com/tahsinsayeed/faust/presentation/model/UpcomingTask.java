        package com.tahsinsayeed.faust.presentation.model;

import javafx.collections.*;

import java.util.*;
import java.util.stream.Collectors;

public class UpcomingTask {
    private ObservableList<ClassViewModel> upcomingClasses;
    private ObservableList<AssignmentViewModel> upcomingAssignments;
    private ObservableList<ExamViewModel> upcomingExams;

    public UpcomingTask(List<ClassViewModel> upcomingClasses,
                        List<AssignmentViewModel> upcomingAssignments, List<ExamViewModel> upcomingExams) {
        this.upcomingClasses = FXCollections.observableArrayList(upcomingClasses);
        this.upcomingAssignments = FXCollections.observableArrayList(upcomingAssignments);
        this.upcomingExams = FXCollections.observableArrayList(upcomingExams);
    }

    public UpcomingTask() {
        this(FXCollections.observableArrayList(), FXCollections.observableArrayList(), FXCollections.observableArrayList());
    }

    public ObservableList<ClassViewModel> getUpcomingClasses() {
        return upcomingClasses;
    }

    public void setUpcomingClasses(List<ClassViewModel> upcomingClasses) {
        this.upcomingClasses.clear();
        this.upcomingClasses.addAll(upcomingClasses);
    }

    public ObservableList<AssignmentViewModel> getUpcomingAssignments() {
        return upcomingAssignments;
    }

    public void setUpcomingAssignments(List<AssignmentViewModel> upcomingAssignments) {
        this.upcomingAssignments.clear();
        this.upcomingAssignments.addAll(upcomingAssignments);
    }

    public ObservableList<ExamViewModel> getUpcomingExams() {
        return upcomingExams;
    }

    public void setUpcomingExams(List<ExamViewModel> upcomingExams) {
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
