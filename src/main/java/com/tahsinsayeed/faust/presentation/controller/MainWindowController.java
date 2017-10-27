package com.tahsinsayeed.faust.presentation.controller;

import com.google.common.eventbus.*;
import com.google.inject.Inject;
import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.business.dto.DtoBank;
import com.tahsinsayeed.faust.presentation.view.SideBarView;
import javafx.animation.Transition;
import javafx.fxml.*;
import javafx.geometry.Pos;
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

    private JFXPopup toolbarPopup;
    public JFXListView<String> listView;

    @Inject
    private EventBus mainEventBus;

    @Inject SideBarView sideBar;

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


        drawer.setSidePane(sideBar.getContainer());


        mainEventBus.register(this);


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ui/popup/MainPopup.fxml"));
        toolbarPopup = new JFXPopup(loader.load());

        optionsBurger.setOnMouseClicked(e -> toolbarPopup.show(optionsBurger,
                JFXPopup.PopupVPosition.TOP,
                JFXPopup.PopupHPosition.RIGHT,
                -12,
                15));

        DtoBank dtoBank = DtoBank.getInstance();

        listView = new JFXListView<>();
        listView.setItems(dtoBank.getUpcomingTask().getList());
        listView.getItems().forEach(e -> System.out.println(e));
        content.getChildren().add(listView);
        content.setAlignment(Pos.CENTER);
        listView.setVerticalGap(20.0);
        listView.setPrefWidth(400);
        listView.setPrefHeight(700);
    }


    @Subscribe
    public void handleNewItemCalss(String item){
        System.out.println(item);

    }

}


