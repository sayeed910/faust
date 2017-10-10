package com.tahsinsayeed.faust.presentation.controller;

import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.presentation.controller.datafx.ExtendedAnimatedFlowContainer;

import com.tahsinsayeed.faust.presentation.view.SideBarView;
import io.datafx.controller.flow.*;
import io.datafx.controller.flow.context.*;
import javafx.animation.Transition;
import javafx.application.Platform;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import io.datafx.controller.*;

import javax.annotation.PostConstruct;

import static io.datafx.controller.flow.container.ContainerAnimations.*;

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

    private JFXPopup toolbarPopup;

    public void initialize() throws Exception{
        System.out.println("init");

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

        SideBarView sideBar = new SideBarView(new SideBarController());

        drawer.setSidePane(sideBar.getContainer());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ui/popup/MainPopup.fxml"));
        toolbarPopup = new JFXPopup(loader.load());

        optionsBurger.setOnMouseClicked(e -> toolbarPopup.show(optionsBurger,
                JFXPopup.PopupVPosition.TOP,
                JFXPopup.PopupHPosition.RIGHT,
                -12,
                15));
//
//        // create the inner flow and content
//        context = new ViewFlowContext();
//        // set the default controller
//        Flow innerFlow = new Flow(ButtonController.class);
//
//        final FlowHandler flowHandler = innerFlow.createHandler(context);
//        context.register("ContentFlowHandler", flowHandler);
//        context.register("ContentFlow", innerFlow);
//        final Duration containerAnimationDuration = Duration.millis(320);
//        drawer.setContent(flowHandler.start(new ExtendedAnimatedFlowContainer(containerAnimationDuration, SWIPE_LEFT)));
//        context.register("ContentPane", drawer.getContent().get(0));
//
//        // side controller will add links to the content flow
//        Flow sideMenuFlow = new Flow(SideMenuController.class);
//        final FlowHandler sideMenuFlowHandler = sideMenuFlow.createHandler(context);
//        drawer.setSidePane(sideMenuFlowHandler.start(new ExtendedAnimatedFlowContainer(containerAnimationDuration,
//                SWIPE_LEFT)));
    }

//    @FXML
//    public void alert(MouseEvent mouseEvent) {
//        drawer.setContent(new Button("button"));
//        drawer.open();
//    }


    }


