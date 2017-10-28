package com.tahsinsayeed.faust.presentation.controller;

import com.google.common.eventbus.*;
import com.google.inject.Inject;
import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.presentation.*;
import com.tahsinsayeed.faust.presentation.event.NewItemEvent;
import com.tahsinsayeed.faust.presentation.view.*;
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

}


