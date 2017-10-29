package com.tahsinsayeed.faust.presentation.view;

import com.jfoenix.controls.JFXCheckBox;
import com.tahsinsayeed.faust.presentation.model.AssignmentViewModel;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

/**
 * Created by sayeed on 10/29/17.
 */
public class AssignmentView extends VBox {

    private final AssignmentViewModel assignmentViewModel;
    private BorderPane titleBar;
    private JFXCheckBox finished;


    public AssignmentView(AssignmentViewModel assignmentViewModel){

        this.assignmentViewModel = assignmentViewModel;
        titleBar = new BorderPane();
        Text title = new Text(assignmentViewModel.getTitle().get());
        title.textProperty().bind(assignmentViewModel.getTitle());
        titleBar.setCenter(title);
        finished = new JFXCheckBox("Done");
        finished.selectedProperty().bind(assignmentViewModel.finishedProperty());
        titleBar.setRight(finished);
    }
}
