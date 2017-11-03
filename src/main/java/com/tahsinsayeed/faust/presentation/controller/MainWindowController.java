package com.tahsinsayeed.faust.presentation.controller;

import com.google.common.eventbus.*;
import com.google.inject.Inject;
import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.business.interactor.Request;
import com.tahsinsayeed.faust.presentation.component.notebook.*;
import com.tahsinsayeed.faust.presentation.component.*;
import com.tahsinsayeed.faust.presentation.entitycreator.EntityCreatorFactory;
import com.tahsinsayeed.faust.presentation.event.*;
import com.tahsinsayeed.faust.presentation.model.NoteViewModel;
import com.tahsinsayeed.faust.presentation.view.*;
import com.tahsinsayeed.faust.util.ContentValues;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class MainWindowController {
    @FXML
    private StackPane root;

    @FXML
    private StackPane titleBurgerContainer;
    @FXML
    private JFXHamburger titleBurger;

    @FXML
    private StackPane optionsBurger;
    @FXML
    private JFXRippler optionsRippler;
    @FXML
    private JFXDrawer drawer;

    @FXML
    private StackPane content;

    @FXML StackPane fab;

    @Inject
    private EventBus mainEventBus;

    @Inject
    SideBarView sideBar;

    @Inject
    EntityCreatorFactory entityCreatorFactory;

    @Inject
    NewItem newItem;

    @Inject
    InteractorFactory interactorFactory;
    @Inject RequestBuilder requestBuilder;

    public void initialize() throws Exception {

        drawer.setOnDrawerOpening(e -> {
            final Transition animation = titleBurger.getAnimation();
            animation.setRate(1);
            animation.play();
        });
        drawer.setOnDrawerClosing(e -> {
            final Transition animation = titleBurger.getAnimation();
            animation.setRate(-1);
            animation.play();
        });
        titleBurgerContainer.setOnMouseClicked(e -> {
            if (drawer.isHidden() || drawer.isHiding()) {
                System.out.println("opening");
                drawer.open();
            } else {
                drawer.close();
            }
        });


        drawer.setSidePane(sideBar);

        fab.getChildren().add(newItem);



        mainEventBus.register(this);

    }


    @Subscribe
    public void handleNewItemCall(NewItemEvent event){
        System.out.println("called " + event.itemName);
        EntityCreationDialog view = entityCreatorFactory.create(event.itemName);
        view.showDialog(root);
    }

    @Subscribe
    public void handleNewNoteCall(EditNoteEvent event){
        NoteViewModel noteViewModel = new NoteViewModel();
        noteViewModel.setId(event.id);
        noteViewModel.setParentCourseId(event.parentCourseId);
        noteViewModel.setTitle(event.title);
        noteViewModel.setContent("");

        NoteEditor editor = NoteEditorFactory.get(mainEventBus, noteViewModel);
        content.getChildren().clear();
        content.getChildren().add(editor);
        editor.loadContent();
    }

    @Subscribe
    public void handleSaveNoteEvent(SaveNoteEvent event){
        System.out.println("called");
        Interactor editNoteInteractor = interactorFactory.make(InteractorFactory.InteractorType.EDIT_NOTE);
        ContentValues values = new ContentValues("id", event.id, "title", event.title, "content", event.content);
        Request editNoteRequest = requestBuilder.make(RequestBuilder.RequestType.EDIT_NOTE, values);
        editNoteInteractor.execute(editNoteRequest);

        System.out.println("saved" + event.content);
    }

}


