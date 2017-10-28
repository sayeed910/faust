package com.tahsinsayeed.faust.presentation.entitycreator.assignmentcreator;

import com.google.inject.Inject;
import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.business.interactor.*;
import com.tahsinsayeed.faust.presentation.controller.*;
import com.tahsinsayeed.faust.util.ContentValues;
import javafx.scene.control.Label;

import java.time.format.DateTimeFormatter;

import static com.google.common.base.Strings.isNullOrEmpty;

public class AssignmentCreationController implements EntityCreationController {

    private final RequestBuilder requestBuilder;
    private InteractorFactory interactorFactory;
    Label error;
    JFXTextField nameInput;
    JFXDatePicker dtDueDate;
    JFXTextArea txtDescription;
    JFXComboBox<String> txtParentCourseId;
    public JFXDialog dialog;

    @Inject
    public AssignmentCreationController(RequestBuilder requestBuilder, InteractorFactory factory){
        this.requestBuilder = requestBuilder;
        this.interactorFactory = factory;
    }

    @Override
    public void add() {

        ContentValues values = getRequestArgs();

        if (!isValid(values)){
            return ;
        }

        Interactor assignmentCreator = interactorFactory.make(InteractorFactory.InteractorType.ADD_ASSIGNMENT);
        Request newAssignmentRequest = requestBuilder.make(RequestBuilder.RequestType.NEW_ASSIGNMENT, values);

       try{
           assignmentCreator.execute(newAssignmentRequest);
       } catch(AssignmentConflict ex){
           error.setText("Assignment with same title already belongs in this course");
       }
    }

    private boolean isValid(ContentValues values) {
        if (isNullOrEmpty(values.get("courseId"))){
            error.setText("Parent Course id cannot be null");
            return false;
        }
        if (isNullOrEmpty(values.get("assignmentTitle"))){
            error.setText("The title of assignment can not be blank");
            return false;
        }
        if (isNullOrEmpty(values.get("dueDate"))){
            error.setText("Please select a valid due date");
        }

        return true;
    }



    private ContentValues getRequestArgs() {
        String courseId = txtParentCourseId.getSelectionModel().getSelectedItem();
        String assignmentTitle = nameInput.getText().trim();
        String dueDate = dtDueDate.getValue().format(DateTimeFormatter.ISO_DATE);
        String description =  txtDescription.getText().trim();

        return new ContentValues(
                "courseId", courseId,
                "assignmentTitle", assignmentTitle,
                "dueDate", dueDate,
                "description", description);

//        file.getAbsolutePath()
    }

    @Override
    public void cancel() {

    }
}
