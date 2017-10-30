package com.tahsinsayeed.faust.presentation.entitycreator.notecreator;

import com.google.inject.Inject;
import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.business.interactor.Request;
import com.tahsinsayeed.faust.presentation.controller.*;
import com.tahsinsayeed.faust.util.ContentValues;
import javafx.scene.control.Label;

/**
 * Created by Shamim on 10/28/17.
 */
public class NoteCreationController implements EntityCreationController {
    JFXComboBox<String> txtParentCourseId ;
    private final RequestBuilder requestBuilder;
    private InteractorFactory interactorFactory;
    Label error;
    JFXTextField nameInput;


    @Inject
    public NoteCreationController(RequestBuilder requestBuilder, InteractorFactory factory){
        this.requestBuilder = requestBuilder;
        this.interactorFactory = factory;
    }

    @Override
    public void add() {
        ContentValues values = getRequestArgs();
        Interactor NoteCreator = interactorFactory.make(InteractorFactory.InteractorType.ADD_NOTE);
        Request newNoteRequest = requestBuilder.make(RequestBuilder.RequestType.NEW_NOTE, values);

        NoteCreator.execute(newNoteRequest);

    }



    private ContentValues getRequestArgs() {
        String parentCourseId = txtParentCourseId.getSelectionModel().getSelectedItem();
        String NoteName = nameInput.getText().trim();


        return new ContentValues(
                "courseId", parentCourseId,
                "NoteName", NoteName
        );

    }

    @Override
    public void cancel() {

    }
}
