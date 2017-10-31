package com.tahsinsayeed.faust.presentation.view;

import com.google.common.eventbus.EventBus;
import com.jfoenix.controls.JFXCheckBox;

import com.tahsinsayeed.faust.presentation.model.CourseViewModel;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

/**
 * Created by IMON on 10/29/17.
 */
public class CourseView extends VBox {

    private CourseViewModel courseViewModel;
    private final EventBus mainEventBus;
    private BorderPane idBar;



    public CourseView(CourseViewModel courseViewModel, EventBus mainEventBus) {
        this.courseViewModel = courseViewModel;
        this.mainEventBus = mainEventBus;

        idBar = new BorderPane();
        Text id = new Text(courseViewModel.getId().get());
        id.textProperty().bind(courseViewModel.getId());
        idBar.setCenter(id);

        VBox body = new VBox();
        body.getChildren().add(new Text("Course Name: " + courseViewModel.getName()));
        body.getChildren().add(new Text("Total Books: " + courseViewModel.getBooks().size()));
        body.getChildren().add(new Text("Total Exams: " + courseViewModel.getExams().size()));
        body.getChildren().add(new Text("Total Notes: " + courseViewModel.getNotes().size()));
        body.getChildren().add(new Text("Total Assignments: " + courseViewModel.getAssignments().size()));


    }


}
