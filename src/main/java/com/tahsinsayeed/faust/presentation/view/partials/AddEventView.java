package com.tahsinsayeed.faust.presentation.view.partials;

import com.tahsinsayeed.faust.business.interactor.AddAssignmentInteractor;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AddEventView implements PartialView {
    VBox container = new VBox();
    private final Label dateLabel;
    private final Label eventLabel;
    private final TextField txtDate;
    private final TextField txtEvent;
    private final HBox firstBox;
    private final HBox secondBox;

    public AddEventView(){
        dateLabel = new Label("Assignment Date: ");
        eventLabel = new Label("Assignment Event: ");
        txtDate = new TextField();
        txtEvent = new TextField();
        firstBox = new HBox(dateLabel, txtDate);
        secondBox = new HBox(eventLabel, txtEvent);
        container.getChildren().addAll(firstBox, secondBox);


    }

    @Override
    public Pane getContainer() {
        return container;
    }

    @Override
    public void onOk() {
//        new AddAssignmentInteractor(txtDate.getText().trim(), txtEvent.getText().trim()).execute();

    }

    @Override
    public void onCancel() {

    }
}
