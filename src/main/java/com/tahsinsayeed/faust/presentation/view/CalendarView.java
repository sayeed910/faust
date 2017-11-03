package com.tahsinsayeed.faust.presentation.view;

import com.jfoenix.controls.JFXButton;
import com.tahsinsayeed.faust.presentation.model.*;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import jfxtras.scene.control.agenda.Agenda;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sayeed on 10/29/17.
 */
public class CalendarView extends VBox {
    List<AssignmentViewModel> assignments;
    List<ExamViewModel> exams;
    Agenda agenda;

    public CalendarView(List<AssignmentViewModel> assignments, List<ExamViewModel> exams) {
        this.assignments = assignments;
        this.exams = exams;
        agenda = new Agenda();
        agenda.appointments().addAll(assignments.stream().map(AssignmentViewModel::getAppointment).collect(Collectors.toList()));
        agenda.appointments().addAll(exams.stream().map(ExamViewModel::getAppointment).collect(Collectors.toList()));
        JFXButton nextWeek = new JFXButton("Next Week>");
        JFXButton lastWeek = new JFXButton("<Last Week");
        nextWeek.setButtonType(JFXButton.ButtonType.RAISED);
        lastWeek.setButtonType(JFXButton.ButtonType.RAISED);

        HBox box = new HBox(lastWeek, nextWeek);
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);
        getChildren().addAll(box, agenda);
        setSpacing(10);
        nextWeek.setOnAction(e-> agenda.setDisplayedLocalDateTime(agenda.getDisplayedLocalDateTime().plusDays(7)));
        lastWeek.setOnAction(e-> agenda.setDisplayedLocalDateTime(agenda.getDisplayedLocalDateTime().minusDays(7)));
    }


}

