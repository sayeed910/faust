package com.tahsinsayeed.faust.presentation.entitycreator.classcreator;

import com.google.inject.Inject;
import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.business.interactor.Request;
import com.tahsinsayeed.faust.presentation.controller.EntityCreationController;
import com.tahsinsayeed.faust.presentation.controller.Interactor;
import com.tahsinsayeed.faust.presentation.controller.InteractorFactory;
import com.tahsinsayeed.faust.presentation.controller.RequestBuilder;
import com.tahsinsayeed.faust.util.ContentValues;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Created by sayeed on 10/26/17.
 */
public class ClassCreationController implements EntityCreationController {
    private final RequestBuilder requestBuilder;
    private InteractorFactory interactorFactory;
    JFXTimePicker startTime;
    JFXComboBox<String> txtParentCourseId;
    HBox firstBox;
    JFXComboBox<String>  txtDayOfWeek;
    Label error;


    @Inject
    public ClassCreationController(RequestBuilder requestBuilder, InteractorFactory factory){
        this.requestBuilder = requestBuilder;
        this.interactorFactory = factory;
    }

    @Override
    public void add() {
        ContentValues values = getRequestArgs();
        Interactor classCreator = interactorFactory.make(InteractorFactory.InteractorType.ADD_CLASS);
        Request newClassRequest = requestBuilder.make(RequestBuilder.RequestType.NEW_CLASS, values);

        classCreator.execute(newClassRequest);

    }



    private ContentValues getRequestArgs() {
        String parentCourseId = txtParentCourseId.getSelectionModel().getSelectedItem();
        String dayOfWeek = txtDayOfWeek.getSelectionModel().getSelectedItem();
        String classTime = startTime.getValue().format(DateTimeFormatter.ISO_LOCAL_TIME);


        return new ContentValues(
                "id", UUID.randomUUID().toString(),
                "courseId", parentCourseId,
                "nameOfDay", dayOfWeek,
                "startTime", classTime
        );

    }

    @Override
    public void cancel() {

    }
}
