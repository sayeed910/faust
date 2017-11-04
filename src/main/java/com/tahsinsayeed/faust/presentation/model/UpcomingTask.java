        package com.tahsinsayeed.faust.presentation.model;

import javafx.collections.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class UpcomingTask {
    private ObservableList<ClassViewModel> upcomingClasses;
    private ObservableList<AssignmentViewModel> upcomingAssignments;
    private ObservableList<ExamViewModel> upcomingExams;

    public UpcomingTask(List<ClassViewModel> classes,
                        List<AssignmentViewModel> assignments, List<ExamViewModel> exams) {
        this.upcomingClasses = FXCollections.observableArrayList(classes.stream().
                filter(classViewModel -> classViewModel.getClassDay() == LocalDate.now().getDayOfWeek())
        .collect(Collectors.toList()));
        this.upcomingAssignments = FXCollections.observableArrayList(assignments.stream().
                filter(assignmentViewModel ->
                        LocalDate.parse(assignmentViewModel.getDueDate()).equals(LocalDate.now()))
                .collect(Collectors.toList()));

        this.upcomingExams = FXCollections.observableArrayList(exams.stream().
                filter(examViewModel ->
                        examViewModel.getExamDate().equals(LocalDate.now()))
                .collect(Collectors.toList()));
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
        List<String> exams =  upcomingExams.stream().map(e->e.getName().get()).collect(Collectors.toList());
        List<String> assignments =  upcomingAssignments.stream().map(e->e.getTitle().get()).collect(Collectors.toList());
        List<String> classes =  upcomingExams.stream().map(e->e.getName().get()).collect(Collectors.toList());

        List<String> items = new ArrayList<>(exams);
        items.addAll(assignments);
        items.addAll(classes);



        return FXCollections.observableArrayList(items);

    }
}
