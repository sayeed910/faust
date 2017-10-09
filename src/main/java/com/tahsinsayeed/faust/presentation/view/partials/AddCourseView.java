package com.tahsinsayeed.faust.presentation.view.partials;

import com.jfoenix.controls.JFXTextField;
import com.tahsinsayeed.faust.business.interactor.AddCourseInteractor;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AddCourseView implements PartialView {
    VBox container = new VBox();
    private final Label idLabel;
    private final Label nameLabel;
    private final JFXTextField txtId;
    private final JFXTextField txtName;
    private final HBox firstBox;
    private final HBox secondBox;

    public AddCourseView(){
        idLabel = new Label("Course Id: ");
        nameLabel = new Label("Course Name: ");
        txtId = new JFXTextField();
        txtName = new JFXTextField();
        firstBox = new HBox(idLabel, txtId);
        secondBox = new HBox(nameLabel, txtName);
        container.getChildren().addAll(firstBox, secondBox);


    }

    @Override
    public Pane getContainer() {
        return container;
    }

    @Override
    public void onOk() {
        new AddCourseInteractor(txtId.getText().trim(), txtName.getText().trim()).execute();

    }

    @Override
    public void onCancel() {

    }
}
