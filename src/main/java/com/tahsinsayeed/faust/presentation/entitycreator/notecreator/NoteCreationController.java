package com.tahsinsayeed.faust.presentation.entitycreator.notecreator;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.business.interactor.Request;
import com.tahsinsayeed.faust.presentation.controller.*;
import com.tahsinsayeed.faust.presentation.event.EditNoteEvent;
import com.tahsinsayeed.faust.util.ContentValues;
import javafx.scene.control.Label;

import java.util.UUID;

/**
 * Created by Shamim on 10/28/17.
 */
public class NoteCreationController implements EntityCreationController {
    JFXComboBox<String> txtParentCourseId ;
    private final RequestBuilder requestBuilder;
    private InteractorFactory interactorFactory;
    Label error;
    JFXTextField nameInput;
    EventBus mainEventBus;

    @Inject
    public NoteCreationController(RequestBuilder requestBuilder, InteractorFactory factory, EventBus mainEventBus){
        this.requestBuilder = requestBuilder;
        this.interactorFactory = factory;
        this.mainEventBus = mainEventBus;
    }

    @Override
    public void add() {

        ContentValues values = getRequestArgs();
        Interactor noteCreator = interactorFactory.make(InteractorFactory.InteractorType.ADD_NOTE);
        Request newExamRequest = requestBuilder.make(RequestBuilder.RequestType.NEW_NOTE, values);

        noteCreator.execute(newExamRequest);


        mainEventBus.post(getNoteEvent(values));
    }

    private ContentValues getRequestArgs() {
        String parentCourseId = txtParentCourseId.getSelectionModel().getSelectedItem();
        String title = nameInput.getText().trim();
        String content =  "";
        String id = UUID.randomUUID().toString();


        return new ContentValues(
                "courseId", parentCourseId,
                "title", title,
                "content", content,
                "id", id
        );

    }



    private EditNoteEvent getNoteEvent(ContentValues values) {
         return new EditNoteEvent(values.get("courseId"), values.get("title"), "", values.get("id"));

    }

    @Override
    public void cancel() {

    }
}
