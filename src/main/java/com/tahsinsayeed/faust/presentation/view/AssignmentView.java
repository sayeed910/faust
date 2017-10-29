package com.tahsinsayeed.faust.presentation.view;

import com.google.common.eventbus.EventBus;
import com.jfoenix.controls.JFXCheckBox;
import com.tahsinsayeed.faust.presentation.event.AssignmentFinishedPropertyChangedEvent;
import com.tahsinsayeed.faust.presentation.model.AssignmentViewModel;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

/**
 * Created by sayeed on 10/29/17.
 */
public class AssignmentView extends VBox {

    private AssignmentViewModel assignmentViewModel;
    private final EventBus mainEventBus;
    private BorderPane titleBar;
    private JFXCheckBox finished;


    public AssignmentView(AssignmentViewModel assignmentViewModel, EventBus mainEventBus) {
        this.assignmentViewModel = assignmentViewModel;
        this.mainEventBus = mainEventBus;

        titleBar = new BorderPane();
        Text title = new Text(assignmentViewModel.getTitle().get());
        title.textProperty().bind(assignmentViewModel.getTitle());
        titleBar.setCenter(title);
        finished = new JFXCheckBox("Done");
        finished.selectedProperty().bindBidirectional(assignmentViewModel.finishedProperty());
        titleBar.setRight(finished);
        VBox body = new VBox();
        body.getChildren().add(new Text("Due on: " + assignmentViewModel.getDueDate()));
        body.getChildren().add(new Text(assignmentViewModel.getDescription().get()));

        finished.setOnAction(e -> toggleFinished());

    }

    private void toggleFinished() {
        finished.setSelected(!finished.isSelected());

        mainEventBus.post(new AssignmentFinishedPropertyChangedEvent(
                assignmentViewModel.getId().get(), finished.isSelected()));

    }
}
