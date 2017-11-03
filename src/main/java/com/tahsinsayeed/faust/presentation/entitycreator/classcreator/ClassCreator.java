package com.tahsinsayeed.faust.presentation.entitycreator.classcreator;

import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.presentation.view.EntityCreationDialog;
import javafx.collections.FXCollections;
import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.util.List;
/**
 * Created by sayeed on 10/26/17.
 */
public class ClassCreator extends EntityCreationDialog {
    VBox container = new VBox();
    BorderPane pane = new BorderPane();
    private final JFXTimePicker startTime;
    private final JFXComboBox<String> txtParentCourseId;
    private final HBox firstBox;
    private final JFXComboBox<String>  txtDayOfWeek;
    private final JFXButton btnOk;
    private final Label title;
    private final Label error;

    private final ClassCreationController controller;

    public ClassCreator(List<String> existingCourseIds, ClassCreationController controller){
        this.controller = controller;

        title = new Label("New Class");
        title.setFont(Font.font(20));
        title.setPadding(new Insets(10, 10, 30, 10));

        txtDayOfWeek= new JFXComboBox<>(FXCollections.observableArrayList("SUNDAY","MONDAY","TUESDAY","WEDNESSDAY","THURSDAY","FRIDAY","SATURDAY"));
        txtDayOfWeek.setPromptText("Day");
        txtDayOfWeek.setLabelFloat(true);

        startTime = new JFXTimePicker();
        startTime.setPromptText("Start Time");

        txtParentCourseId = new JFXComboBox<>(FXCollections.observableArrayList(existingCourseIds));
        txtParentCourseId.setLabelFloat(true);
        txtParentCourseId.setPromptText("Course Id");

        btnOk = new JFXButton("Ok");
        firstBox = new HBox(btnOk);
        btnOk.setOnAction(e -> controller.add());

        error = new Label();
        error.setTextFill(Paint.valueOf("red"));


        firstBox.setAlignment(Pos.BASELINE_RIGHT);

        container.getChildren().addAll(title, txtParentCourseId, txtDayOfWeek, startTime,btnOk);
        container.setSpacing(20);
        pane.setCenter(container);
        pane.setBottom(firstBox);
        pane.setPrefHeight(300);
        pane.setPrefWidth(400);
        pane.setPadding(new Insets(30, 30, 30, 30));



        controller.startTime = startTime;
        controller.txtDayOfWeek = txtDayOfWeek;
        controller.txtParentCourseId = txtParentCourseId;
        controller.error = error;


    }

    @Override
    protected Pane getContent(){
        return pane;
    }
}
