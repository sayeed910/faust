package com.tahsinsayeed.faust.presentation.view;

import com.google.common.eventbus.EventBus;
import com.jfoenix.controls.JFXToggleButton;
import com.tahsinsayeed.faust.presentation.event.AssignmentFinishedPropertyChangedEvent;
import com.tahsinsayeed.faust.presentation.model.AssignmentViewModel;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;

/**
 * Created by IMON on 10/29/17.
 */
public class AssignmentView extends VBox {

    private AssignmentViewModel assignmentViewModel;
    private final EventBus mainEventBus;
    private BorderPane titleBar;
    private JFXToggleButton finished;


    public AssignmentView(AssignmentViewModel assignmentViewModel, EventBus mainEventBus) {
        this.assignmentViewModel = assignmentViewModel;
        this.mainEventBus = mainEventBus;
        titleBar = new BorderPane();
        Text title = new Text(assignmentViewModel.getTitle().get());
        title.setFont(Font.font(24));
        Insets topInsets;
        topInsets= new Insets(30,10,10,40);
        this.setPadding(topInsets);
        titleBar.setLeft(title);
        finished = new JFXToggleButton();
        finished.setSelected(true);

        titleBar.setRight(finished);


        setBackground(new Background(new BackgroundFill(Paint.valueOf("white"), null, null)));
        getChildren().add(titleBar);

        Text due = new Text("Due on: " + assignmentViewModel.getDueDate());
        due.setFont(Font.font(20));
        getChildren().add(due);

        Text CourseID= (new Text("Course Id -"+(assignmentViewModel.getParentCourseId().get())));
        CourseID.setFont(Font.font(18));
        getChildren().add(CourseID);

        Text Description=(new Text(assignmentViewModel.getDescription().get()));
        Description.setFont(Font.font(14));
        getChildren().add(Description);
        setMaxSize(500, 300);

//        finished.setOnAction(e -> toggleFinished());


    }

    private void toggleFinished() {
        System.out.println("toggled");
        mainEventBus.post(new AssignmentFinishedPropertyChangedEvent(
                assignmentViewModel.getId().get(), finished.isSelected()));

    }
}
