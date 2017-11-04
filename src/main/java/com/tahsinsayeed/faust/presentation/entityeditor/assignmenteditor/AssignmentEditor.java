package com.tahsinsayeed.faust.presentation.entityeditor.assignmenteditor;

import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.presentation.model.AssignmentViewModel;
import com.tahsinsayeed.faust.presentation.view.EntityCreationDialog;
import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

/**
 * Created by sayeed on 11/4/17.
 */
public class AssignmentEditor extends EntityCreationDialog {
    VBox container = new VBox();
    BorderPane pane = new BorderPane();
    private final JFXTextField nameInput;
    private final JFXDatePicker dtDueDate;
    private final Label txtParentCourseId;
    private final HBox firstBox;
    private final JFXTextArea txtdescription;
    private final JFXButton btnOk;
    private final Label title;
    private final Label error;

    private final AssignmentEditorController controller;

    public AssignmentEditor(AssignmentViewModel viewModel, AssignmentEditorController controller) {
        this.controller = controller;

        title = new Label("Edit Assignment");
        title.setFont(Font.font(20));
        title.setPadding(new Insets(10, 10, 30, 10));

        nameInput = new JFXTextField();
        nameInput.setPromptText("Assignment Title");
        nameInput.setLabelFloat(true);
        dtDueDate = new JFXDatePicker();
        dtDueDate.setOverLay(false);
        dtDueDate.setPromptText("Due Date");

        txtParentCourseId = new Label(viewModel.getParentCourseId().get());


        txtdescription = new JFXTextArea();
        txtdescription.setPromptText("Description");
        txtdescription.setLabelFloat(true);

        btnOk = new JFXButton("Ok");
        firstBox = new HBox(btnOk);
        btnOk.setOnAction(e -> controller.add());

        error = new Label();
        error.setTextFill(Paint.valueOf("red"));

        firstBox.setAlignment(Pos.BASELINE_RIGHT);

        container.getChildren().addAll(title, txtParentCourseId, nameInput, dtDueDate);
        container.setSpacing(20);
        pane.setCenter(container);
        pane.setBottom(firstBox);
        pane.setPrefHeight(300);
        pane.setPrefWidth(400);
        pane.setPadding(new Insets(30, 30, 30, 30));

        controller.error = error;
        controller.nameInput = nameInput;
        controller.dtDueDate = dtDueDate;
        controller.txtDescription = txtdescription;
        controller.txtParentCourseId = txtParentCourseId;
        controller.dialog = dialog;
        controller.viewModel = viewModel;
    }

    @Override
    protected Pane getContent() {
        return pane;
    }
}
