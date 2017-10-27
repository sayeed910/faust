package com.tahsinsayeed.faust.presentation.view.partials;

//import com.tahsinsayeed.faust.business.interactor.AddAttendanceInteractor;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AddAttendanceView implements PartialView {
    VBox container = new VBox();
    private final Label classHeldLabel;
    private final Label classAttendedLabel;
    private final JFXTextField txtClassHeld;
    private final JFXTextField txtClassAttended;
    private final HBox firstBox;
    private final HBox secondBox;

    public AddAttendanceView(){
        classHeldLabel = new Label("Attendance ClassHeld: ");
        classAttendedLabel = new Label("Attendance ClassAttended: ");
        txtClassHeld = new JFXTextField();
        txtClassAttended = new JFXTextField();
        firstBox = new HBox(classHeldLabel, txtClassHeld);
        secondBox = new HBox(classAttendedLabel, txtClassAttended);
        container.getChildren().addAll(firstBox, secondBox);


    }

    @Override
    public Pane getContainer() {
        return container;
    }

    @Override
    public void onOk() {
//        new AddAttendanceInteractor(txtClassHeld.getText().trim(), txtClassAttended.getText().trim()).execute();

    }

    @Override
    public void onCancel() {

    }
}
