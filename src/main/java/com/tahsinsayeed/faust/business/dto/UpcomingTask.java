package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Exam;
import javafx.collections.*;

import java.util.List;

public class UpcomingTask {
    public ObservableList<ClassDto> upcomingClasses;
    public ObservableList<AssignmentDto> upcomingAssignments;
    public ObservableList<ExamDto> upcomingExams;

    public UpcomingTask(List<ClassDto> upcomingClasses,
                        List<AssignmentDto> upcomingAssignments, List<ExamDto> upcomingExams) {
        this.upcomingClasses = FXCollections.observableArrayList(upcomingClasses);
        this.upcomingAssignments = FXCollections.observableArrayList(upcomingAssignments);
        this.upcomingExams = FXCollections.observableArrayList(upcomingExams);
    }

    public UpcomingTask() {
        this(FXCollections.observableArrayList(), FXCollections.observableArrayList(), FXCollections.observableArrayList());
    }
}
