package com.tahsinsayeed.faust.presentation.entitycreator.examcreator;

import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.business.interactor.Request;
import com.tahsinsayeed.faust.presentation.controller.*;
import com.tahsinsayeed.faust.util.ContentValues;
import javafx.scene.control.Label;

import java.time.format.DateTimeFormatter;

/**
 * Created by sayeed on 10/26/17.
 */
public class ExamCreationController implements EntityCreationController {
    private final RequestBuilder requestBuilder;
    private InteractorFactory interactorFactory;
    Label error;
    JFXTextField nameInput;
    JFXDatePicker dtExamDate;
    JFXTimePicker examTime;
    JFXComboBox<String> txtParentCourseId;
    public JFXTextField fullMarksInput;
    public JFXTextField receivedMarksInput;

    public ExamCreationController(RequestBuilder requestBuilder, InteractorFactory factory){
        this.requestBuilder = requestBuilder;
        this.interactorFactory = factory;
    }

    @Override
    public void add() {
        ContentValues values = getRequestArgs();
        Interactor examCreator = interactorFactory.make(InteractorFactory.InteractorType.ADD_EXAM);
        Request newExamRequest = requestBuilder.make(RequestBuilder.RequestType.NEW_EXAM, values);

        examCreator.execute(newExamRequest);

    }



    private ContentValues getRequestArgs() {
        String parentCourseId = txtParentCourseId.getSelectionModel().getSelectedItem();
        String examName = nameInput.getText().trim();
        String dateOfExam = dtExamDate.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String timeOfExam = examTime.getValue().format(DateTimeFormatter.ISO_LOCAL_TIME);
        String fullMarks =  fullMarksInput.getText();
        String receivedMarks = receivedMarksInput.getText();


        return new ContentValues(
                "courseId", parentCourseId,
                "examName", examName,
                "examDate", dateOfExam,
                "examTime", timeOfExam,
                "fullMarks", fullMarks,
                "receivedMarks", receivedMarks
                );

    }

    @Override
    public void cancel() {

    }
}
