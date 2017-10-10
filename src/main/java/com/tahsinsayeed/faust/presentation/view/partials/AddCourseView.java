package com.tahsinsayeed.faust.presentation.view.partials;

import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.business.interactor.AddCourseInteractor;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

import java.util.Stack;

public class AddCourseView implements PartialView {
    BorderPane pane;
    VBox container;
//    private final Label idLabel;
//    private final Label nameLabel;
    private final JFXTextField txtId;
    private final JFXTextField txtName;
    private final JFXButton btnOk;


    private final HBox firstBox;
    private final HBox secondBox;
    private final HBox thirdBox;


    public AddCourseView(JFXDialog dialog){
        Label title = new Label("New Course");
        title.setFont(Font.font(20));
        title.setPadding(new Insets(10, 10, 30, 10));


//        idLabel = new Label("Course Id: ");
//        nameLabel = new Label("Course Name: ");
        txtId = new JFXTextField();
        txtId.setLabelFloat(true);
        txtId.setPromptText("Course Id");
        txtName = new JFXTextField();
        txtName.setLabelFloat(true);
        txtName.setPromptText("Course Name");
        btnOk = new JFXButton("OK");
        btnOk.setButtonType(JFXButton.ButtonType.FLAT);
        btnOk.setOnAction((e)-> {onOk();dialog.close();});

        pane = new BorderPane();
        firstBox = new HBox(txtId);
        secondBox = new HBox(txtName);
        thirdBox = new HBox(btnOk);
        thirdBox.setAlignment(Pos.BASELINE_RIGHT);
        container = new VBox();
        container.setSpacing(20);

        container.getChildren().addAll(title, firstBox, secondBox);
        pane.setBottom(thirdBox);
        pane.setCenter(this.container);
        pane.setPadding(new Insets(30, 30, 30, 30));
        pane.setPrefWidth(400);
        pane.setPrefHeight(300);

    }

    @Override
    public Pane getContainer() {
        return pane;
    }

    @Override
    public void onOk() {
        new AddCourseInteractor(txtId.getText().trim(), txtName.getText().trim()).execute();

    }

    @Override
    public void onCancel() {

    }
}
