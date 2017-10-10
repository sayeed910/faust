package com.tahsinsayeed.faust.presentation.view.partials;

import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.business.interactor.AddAssignmentInteractor;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AddAssignmentView implements PartialView {
    VBox container = new VBox();
    private final Label titleLabel;
    private final Label dueDateLabel;
    private final JFXTextField txtTitle;
    private final JFXDatePicker txtDueDate;
    private final Label lblParentCourseId;
    private final JFXTextField txtParentCourseId;
    private final HBox firstBox;
    private final HBox secondBox;
    private final HBox thirdBox;
    private final JFXDatePicker datePicker;


    public AddAssignmentView(){
        titleLabel = new Label("Assignment Title: ");
        dueDateLabel = new Label("Assignment DueDate: ");
        lblParentCourseId = new Label("CourseId of Parent: ");
        txtTitle = new JFXTextField();
        txtDueDate = new JFXDatePicker();
        txtDueDate.setOverLay(false);
        txtParentCourseId = new JFXTextField();
        firstBox = new HBox(titleLabel, txtTitle);
        datePicker = new JFXDatePicker();
        datePicker.setOverLay(false);
        secondBox = new HBox(dueDateLabel, datePicker);
        thirdBox = new HBox(lblParentCourseId, txtParentCourseId);
        container.getChildren().addAll(firstBox, secondBox, thirdBox);


    }

    @Override
    public Pane getContainer() {
        return container;
    }

    @Override
    public void onOk() {
        new AddAssignmentInteractor(txtParentCourseId.getText().trim(),
                txtTitle.getText().trim(),
                datePicker.getValue(), "").execute();

    }

    @Override
    public void onCancel() {

    }
}
