package com.tahsinsayeed.faust.presentation.view.partials;

//import com.tahsinsayeed.faust.business.interactor.AddSemesterInteractor;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AddSemesterView implements PartialView {
    VBox container = new VBox();
    private final Label id;
    private final Label startdate;
    private final Label endDate;
    private final JFXTextField txtId;
    private final JFXDatePicker txtStartdate;
    private final JFXDatePicker txtEndDate;
    private final HBox firstBox;
    private final HBox secondBox;
    private final HBox thirdBox;

    public AddSemesterView(){
        id = new Label("Semester Id: ");
        startdate = new Label("Semester Startdate: ");
        endDate = new Label("Semester EndDate: ");
        txtId = new JFXTextField();
        txtStartdate = new JFXDatePicker();
        txtStartdate.setOverLay(false);
        txtEndDate = new JFXDatePicker();
        txtEndDate.setOverLay(false);
        firstBox = new HBox(id, txtId);
        secondBox = new HBox(startdate, txtStartdate);
        thirdBox = new HBox(endDate, txtEndDate);
        container.getChildren().addAll(firstBox, secondBox, thirdBox);


    }

    @Override
    public Pane getContainer() {
        return container;
    }

    @Override
    public void onOk() {
//        new AddSemesterInteractor(txtId.getText().trim(), txtStartdate.getText().trim(), txtEndDate.getText()).execute();

    }

    @Override
    public void onCancel() {

    }
}
