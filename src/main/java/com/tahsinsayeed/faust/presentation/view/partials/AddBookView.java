package com.tahsinsayeed.faust.presentation.view.partials;

import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.business.interactor.AddBookInteractor;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AddBookView implements PartialView {
    VBox container = new VBox();
    private final Label nameLabel;
    private final Label pathLabel;
    private final JFXTextField txtName;
    private final JFXTextField txtPath;
    private final HBox firstBox;
    private final HBox secondBox;

    public AddBookView(JFXDialog dialog){
        nameLabel = new Label("Book Name: ");
        pathLabel = new Label("Book Path: ");
        txtName = new JFXTextField();
        txtPath = new JFXTextField();
        firstBox = new HBox(nameLabel, txtName);
        secondBox = new HBox(pathLabel, txtPath);
        container.getChildren().addAll(firstBox, secondBox);


    }

    @Override
    public Pane getContainer() {
        return container;
    }

    @Override
    public void onOk() {
//        new AddBookInteractor(txtName.getText().trim(), txtPath.getText().trim()).execute();

    }

    @Override
    public void onCancel() {

    }
}
