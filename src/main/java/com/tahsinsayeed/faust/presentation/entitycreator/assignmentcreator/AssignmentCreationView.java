package com.tahsinsayeed.faust.presentation.entitycreator.assignmentcreator;

import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.presentation.view.EntityCreationView;
import javafx.collections.FXCollections;
import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.util.List;

public class AssignmentCreationView extends BorderPane implements EntityCreationView {
    VBox container = new VBox();
    private final JFXTextField nameInput;
    private final JFXDatePicker dtDueDate;
    private final JFXComboBox<String> txtParentCourseId;
    private final HBox firstBox;
    private final JFXTextArea txtdescription;
    private final JFXButton btnOk;
    private final Label title;
    private final Label error;

    private final AssignmentCreationController controller;

    public AssignmentCreationView(List<String> existingCourseIds, AssignmentCreationController controller){
        this.controller = controller;

        title = new Label("New Assignment");
        title.setFont(Font.font(20));
        title.setPadding(new Insets(10, 10, 30, 10));

        nameInput = new JFXTextField();
        nameInput.setPromptText("Assignment Title");
        nameInput.setLabelFloat(true);
        dtDueDate = new JFXDatePicker();
        dtDueDate.setOverLay(false);
        dtDueDate.setPromptText("Due Date");

        txtParentCourseId = new JFXComboBox<>(FXCollections.observableArrayList(existingCourseIds));
        txtParentCourseId.setLabelFloat(true);
        txtParentCourseId.setPromptText("Course Id");

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
        this.setCenter(container);
        this.setBottom(firstBox);
        this.setPrefHeight(300);
        this.setPrefWidth(400);
        this.setPadding(new Insets(30, 30, 30, 30));



        controller.error = error;
        controller.nameInput = nameInput;
        controller.dtDueDate = dtDueDate;
        controller.txtDescription = txtdescription;
        controller.txtParentCourseId = txtParentCourseId;

    }

    @Override
    public void showDialog(StackPane root) {

    }
}
