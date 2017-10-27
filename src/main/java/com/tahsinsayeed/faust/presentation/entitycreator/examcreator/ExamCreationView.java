package com.tahsinsayeed.faust.presentation.entitycreator.examcreator;

import com.jfoenix.controls.*;
import com.jfoenix.validation.*;
import com.tahsinsayeed.faust.presentation.view.EntityCreationView;
import com.tahsinsayeed.faust.ui.component.FloatingTextField;
import javafx.collections.FXCollections;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;


import java.util.List;

public class ExamCreationView extends BorderPane implements EntityCreationView{
    private final JFXComboBox<String> txtParentCourseId;
    VBox container = new VBox();
    private final JFXTextField nameInput;
    private final JFXTextField fullMarksInput;
    private final JFXTextField receivedMarksInput;
    private final JFXDatePicker dtExamDate;
    private final JFXTimePicker examTime;
    private final HBox bottomContainer;
    private Button btnOk;
    private Label error;
    private final ExamCreationController controller;

    public ExamCreationView(ExamCreationController controller, List<String> existingCourseIds){
        this.controller = controller;

        Label title = new Label("New Exam");
        title.setFont(Font.font(20));
        title.setPadding(new Insets(10, 10, 30, 10));

        nameInput = FloatingTextField.withPromptText("Exam Name");
        nameInput.setValidators(new RequiredFieldValidator());

        fullMarksInput = new FloatingTextField("10", "Full Marks");
        fullMarksInput.setValidators(new NumberValidator());

        receivedMarksInput = new FloatingTextField("0", "Received Marks");
        receivedMarksInput.setValidators(new NumberValidator());



        dtExamDate = new JFXDatePicker();
        dtExamDate.setPromptText("Exam Date");
        dtExamDate.setOverLay(false);

        examTime = new JFXTimePicker();
        examTime.setPromptText("Exam Time");

        txtParentCourseId = new JFXComboBox<>(FXCollections.observableArrayList(existingCourseIds));
        txtParentCourseId.setLabelFloat(true);
        txtParentCourseId.setPromptText("Course Id");

        btnOk = new JFXButton("OK");
        btnOk.setOnAction(e -> controller.add());

        error = new Label();
        error.setTextFill(Paint.valueOf("red"));

        bottomContainer = new HBox(btnOk);
        bottomContainer.setAlignment(Pos.BASELINE_RIGHT);
        container.getChildren().addAll(title, txtParentCourseId, nameInput, dtExamDate, examTime, error);
        container.setSpacing(20);
        this.setCenter(container);
        this.setBottom(bottomContainer);
        this.setPrefHeight(300);
        this.setPrefWidth(400);
        this.setPadding(new Insets(30, 30, 30, 30));


        controller.nameInput = nameInput;
        controller.dtExamDate = dtExamDate;
        controller.examTime = examTime;
        controller.txtParentCourseId = txtParentCourseId;
        controller.fullMarksInput = fullMarksInput;
        controller.receivedMarksInput = receivedMarksInput;
        controller.error = error;
    }

    @Override
    public void showDialog(StackPane root) {

    }
}
