package com.tahsinsayeed.faust.presentation.entitycreator.coursecreator;

import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.presentation.view.EntityCreationView;
import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class CourseCreationView implements EntityCreationView {
    final VBox centerContainer;
    final BorderPane pane;
    final JFXTextField idInput;
    final JFXTextField nameInput;
    final JFXButton btnOk;
    final Label error;
    final HBox bottomPane;
    private final Label title;
    final JFXDialog dialog;

    private final CourseCreationController controller;

    @Injec
    public CourseCreationView(CourseCreationController controller){
        this.controller = controller;
        title = new Label("New Course");
        title.setFont(Font.font(20));
        title.setPadding(new Insets(10, 10, 30, 10));

        idInput = new JFXTextField();
        idInput.setLabelFloat(true);
        idInput.setPromptText("Course Id");

        nameInput = new JFXTextField();
        nameInput.setLabelFloat(true);
        nameInput.setPromptText("Course Name");

        error = new Label();
        error.setTextFill(Paint.valueOf("red"));

        btnOk = new JFXButton("OK");
        btnOk.setButtonType(JFXButton.ButtonType.FLAT);
        btnOk.setOnAction(e -> controller.add());


        bottomPane = new HBox(btnOk);
        bottomPane.setAlignment(Pos.BASELINE_RIGHT);
        centerContainer = new VBox(title, idInput, nameInput, error);
        centerContainer.setSpacing(20);

        dialog = new JFXDialog();


        pane = new BorderPane();
        pane.setBottom(bottomPane);
        pane.setCenter(centerContainer);
        pane.setPadding(new Insets(30, 30, 5, 30));
        pane.setPrefWidth(400);
        pane.setPrefHeight(300);

        controller.error = error;
        controller.idInput = idInput;
        controller.nameInput = nameInput;

    }

    @Override
    public void showDialog(StackPane container) {
        dialog.setContent(pane);
        dialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
        dialog.show(container);
    }
}
