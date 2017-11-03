package com.tahsinsayeed.faust.presentation.entitycreator.notecreator;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.presentation.controller.*;
import com.tahsinsayeed.faust.presentation.event.NewNoteEvent;
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
    EventBus mainEventBus;

    @Inject
    public NoteCreationController(RequestBuilder requestBuilder, InteractorFactory factory, EventBus mainEventBus){
        this.requestBuilder = requestBuilder;
        this.interactorFactory = factory;
        this.mainEventBus = mainEventBus;
    }

    @Override
    public void add() {
        mainEventBus.post(getNoteEvent());
    }



    private NewNoteEvent getNoteEvent() {
        String parentCourseId = txtParentCourseId.getSelectionModel().getSelectedItem();
        String noteName = nameInput.getText().trim();


        return new NewNoteEvent(parentCourseId, noteName);

    }

    @Override
    public void cancel() {

    }
}
