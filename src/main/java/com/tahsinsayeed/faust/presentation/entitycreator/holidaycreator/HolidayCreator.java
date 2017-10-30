package com.tahsinsayeed.faust.presentation.entitycreator.holidaycreator;

import com.google.inject.Inject;
import com.jfoenix.controls.*;
import com.jfoenix.validation.RequiredFieldValidator;
import com.tahsinsayeed.faust.presentation.view.EntityCreationDialog;
import com.tahsinsayeed.faust.ui.component.FloatingTextField;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

/*
        Creted by Shamim 10/28/2017
*/

public class HolidayCreator extends EntityCreationDialog{
    VBox container = new VBox();
    BorderPane pane = new BorderPane();
    private final JFXTextField nameInput;
    private final JFXDatePicker dtHolidayDate;
    private final HBox bottomContainer;
    private Button btnOk;
    private Label error;

    private final HolidayCreationController controller;

    @Inject
    public HolidayCreator(HolidayCreationController controller){
        this.controller = controller;

        Label title = new Label("New Holiday");
        title.setFont(Font.font(20));
        title.setPadding(new Insets(10, 10, 30, 10));

        nameInput = FloatingTextField.withPromptText("Holiday Name");
        nameInput.setValidators(new RequiredFieldValidator());

        dtHolidayDate = new JFXDatePicker();
        dtHolidayDate.setPromptText("Holiday Date");
        dtHolidayDate.setOverLay(false);

        btnOk = new JFXButton("OK");
        btnOk.setOnAction(e -> controller.add());

        error = new Label();
        error.setTextFill(Paint.valueOf("red"));

        bottomContainer = new HBox(btnOk);
        bottomContainer.setAlignment(Pos.BASELINE_RIGHT);
        container.getChildren().addAll(title, nameInput, dtHolidayDate,error);
        container.setSpacing(20);
        pane.setCenter(container);
        pane.setBottom(bottomContainer);
        pane.setPrefHeight(300);
        pane.setPrefWidth(400);
        pane.setPadding(new Insets(30, 30, 30, 30));


        controller.nameInput = nameInput;
        controller.dtHolidayDate = dtHolidayDate;
        controller.error = error;
    }

    @Override
    protected Pane getContent() {
        return pane;
    }
}
