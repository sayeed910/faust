package com.tahsinsayeed.faust.presentation.view.partials;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.tahsinsayeed.faust.business.interactor.AddExamInteractor;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AddExamView implements PartialView {
    VBox container = new VBox();
    private final Label examName;
    private final Label examDate;
    private final Label examTime;
    private final JFXTextField txtExamName;
    private final JFXDatePicker txtExamDate;
    private final JFXTextField txtExamTime;
    private final HBox firstBox;
    private final HBox secondBox;
    private final HBox thirdBox;

    public AddExamView(){
        examName = new Label("Exam ExamName: ");
        examDate = new Label("Exam ExamDate: ");
        examTime = new Label("Exam ExamTime: ");
        txtExamName = new JFXTextField();
        txtExamDate = new JFXDatePicker();
        txtExamDate.setOverLay(false);
        txtExamTime = new JFXTextField();
        firstBox = new HBox(examName, txtExamName);
        secondBox = new HBox(examDate, txtExamDate);
        thirdBox = new HBox(examTime, txtExamTime);
        container.getChildren().addAll(firstBox, secondBox, thirdBox);


    }

    @Override
    public Pane getContainer() {
        return container;
    }

    @Override
    public void onOk() {
//        new AddExamInteractor(txtExamName.getText().trim(), txtExamDate.getText().trim(), txtExamTime.getText()).execute();

    }

    @Override
    public void onCancel() {

    }
}
