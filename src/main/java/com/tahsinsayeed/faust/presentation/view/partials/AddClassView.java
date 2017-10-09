package com.tahsinsayeed.faust.presentation.view.partials;

import com.tahsinsayeed.faust.business.interactor.AddClassInteractor;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AddClassView implements PartialView {
    VBox container = new VBox();
    private final Label courseLabel;
    private final Label dayLabel;
    private final Label startTimeLabel;
    private final TextField txtCourse;
    private final TextField txtDay;
    private final TextField txtStartTime;
    private final HBox firstBox;
    private final HBox secondBox;
    private final HBox thirdBox;

    public AddClassView(){
        courseLabel = new Label("Class Course: ");
        dayLabel = new Label("Class Day: ");
        startTimeLabel = new Label("Class StartTime: ");
        txtCourse = new TextField();
        txtDay = new TextField();
        txtStartTime = new TextField();
        firstBox = new HBox(courseLabel, txtCourse);
        secondBox = new HBox(dayLabel, txtDay);
        thirdBox = new HBox(startTimeLabel, txtStartTime);
        container.getChildren().addAll(firstBox, secondBox, thirdBox);


    }

    @Override
    public Pane getContainer() {
        return container;
    }

    @Override
    public void onOk() {
//        new AddClassInteractor(txtCourse.getText().trim(), txtDay.getText().trim(), txtStartTime.getText()).execute();

    }

    @Override
    public void onCancel() {

    }
}
