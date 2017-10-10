package com.tahsinsayeed.faust.presentation.view.partials;

//import com.tahsinsayeed.faust.business.interactor.AddHolidayInteractor;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AddHolidayView implements PartialView {
    VBox container = new VBox();
    private final Label dateLabel;
    private final Label eventLabel;
    private final JFXDatePicker txtDate;
    private final JFXTextField txtEvent;
    private final HBox firstBox;
    private final HBox secondBox;

    public AddHolidayView(){
        dateLabel = new Label("Holiday Date: ");
        eventLabel = new Label("Holiday Event: ");
        txtDate = new JFXDatePicker();
        txtDate.setOverLay(false);
        txtEvent = new JFXTextField();
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
//        new AddHolidayInteractor(txtDate.getText().trim(), txtEvent.getText().trim()).execute();

    }

    @Override
    public void onCancel() {

    }
}
