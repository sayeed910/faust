package com.tahsinsayeed.faust.presentation.view;

import com.tahsinsayeed.faust.presentation.model.*;
import javafx.scene.layout.StackPane;
import jfxtras.scene.control.agenda.Agenda;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sayeed on 10/29/17.
 */
public class CalendarView extends StackPane {
    List<AssignmentViewModel> assignments;
    List<ExamViewModel> exams;
    Agenda agenda;

    public CalendarView(List<AssignmentViewModel> assignments, List<ExamViewModel> exams) {
        this.assignments = assignments;
        this.exams = exams;
        agenda = new Agenda();
        agenda.appointments().addAll(assignments.stream().map(AssignmentViewModel::getAppointment).collect(Collectors.toList()));
        agenda.appointments().addAll(exams.stream().map(ExamViewModel::getAppointment).collect(Collectors.toList()));

        getChildren().add(agenda);
    }


}

