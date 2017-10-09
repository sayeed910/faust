package com.tahsinsayeed.faust.presentation.view.partials;

import com.tahsinsayeed.faust.business.interactor.AddExamInteractor;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AddExamView implements PartialView {
    VBox container = new VBox();
    private final Label examName;
    private final Label examDate;
    private final Label examTime;
    private final TextField txtExamName;
    private final TextField txtExamDate;
    private final TextField txtExamTime;
    private final HBox firstBox;
    private final HBox secondBox;
    private final HBox thirdBox;

    public AddExamView(){
        examName = new Label("Exam ExamName: ");
        examDate = new Label("Exam ExamDate: ");
        examTime = new Label("Exam ExamTime: ");
        txtExamName = new TextField();
        txtExamDate = new TextField();
        txtExamTime = new TextField();
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
