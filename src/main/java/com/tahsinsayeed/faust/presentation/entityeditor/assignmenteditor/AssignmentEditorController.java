package com.tahsinsayeed.faust.presentation.entityeditor.assignmenteditor;

import com.google.inject.Inject;
import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.business.interactor.*;
import com.tahsinsayeed.faust.presentation.controller.*;
import com.tahsinsayeed.faust.presentation.model.AssignmentViewModel;
import com.tahsinsayeed.faust.util.ContentValues;
import javafx.scene.control.Label;

import java.time.format.DateTimeFormatter;

/**
 * Created by sayeed on 11/4/17.
 */
public class AssignmentEditorController {
    private final RequestBuilder requestBuilder;
    private InteractorFactory interactorFactory;
    Label error;
    JFXTextField nameInput;
    JFXDatePicker dtDueDate;
    JFXTextArea txtDescription;
    Label txtParentCourseId;
    public JFXDialog dialog;
    AssignmentViewModel viewModel;

    @Inject
    public AssignmentEditorController(RequestBuilder requestBuilder, InteractorFactory factory){
        this.requestBuilder = requestBuilder;
        this.interactorFactory = factory;
    }


    public void add() {

        ContentValues values = getRequestArgs();

        Interactor assignmentCreator = interactorFactory.make(InteractorFactory.InteractorType.EDIT_ASSIGNMENT);
        Request newAssignmentRequest = requestBuilder.make(RequestBuilder.RequestType.EDIT_ASSIGNMENT, values);

        try{
            assignmentCreator.execute(newAssignmentRequest);
            dialog.close();
        } catch(AssignmentConflict ex){
            error.setText("Assignment with same title already belongs in this course");
        }
    }



    private ContentValues getRequestArgs() {
        String assignmentTitle = nameInput.getText().trim();
        String dueDate = dtDueDate.getValue().format(DateTimeFormatter.ISO_DATE);
        String description =  txtDescription.getText().trim();

        return new ContentValues(
                "assignmentTitle", assignmentTitle,
                "dueDate", dueDate,
                "description", description,
                "id", viewModel.getId().get(),
                "finished", Boolean.toString(viewModel.isFinished()));

    }


}
