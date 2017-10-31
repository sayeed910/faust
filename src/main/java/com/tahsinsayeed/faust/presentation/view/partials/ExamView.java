package com.tahsinsayeed.faust.presentation.view;

import com.google.common.eventbus.EventBus;
import com.jfoenix.controls.JFXCheckBox;

import com.tahsinsayeed.faust.presentation.model.ExamViewModel;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

/**
 * Created by IMON on 10/29/17.
 */
public class ExamView extends VBox {

    private ExamViewModel examViewModel;
    private final EventBus mainEventBus;
    private BorderPane idBar;



    public ExamView(ExamViewModel examViewModel, EventBus mainEventBus) {
        this.examViewModel = examViewModel;
        this.mainEventBus = mainEventBus;

        idBar = new BorderPane();
        Text id = new Text(examViewModel.getId().get());
        id.textProperty().bind(examViewModel.getId());
        idBar.setCenter(id);

        VBox body = new VBox();
        body.getChildren().add(new Text("Exam Date: " + examViewModel.getExamDate()));
        body.getChildren().add(new Text("Exam Time " + examViewModel.getExamTime()));
        body.getChildren().add(new Text("Total Marks " + examViewModel.getTotalMark()));
        body.getChildren().add(new Text("Received Marks: " + examViewModel.getReceivedMark()));


    }


}
