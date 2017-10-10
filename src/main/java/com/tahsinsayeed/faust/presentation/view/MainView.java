package com.tahsinsayeed.faust.presentation.view;

import com.sun.prism.paint.Color;
import com.tahsinsayeed.faust.presentation.controller.SideBarController;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

public class MainView implements View {

    BorderPane container;
    SideBarView sideBar;

    public MainView() {
        SideBarController sideBarController = new SideBarController();
        sideBar = new SideBarView(sideBarController);
        this.container = new BorderPane();
        Pane leftPane = sideBar.getContainer();
        this.container.setLeft(leftPane);
//        leftPane.prefHeightProperty().bind(container.heightProperty());
    }

    @Override
    public Pane getContainer() {
        return container;
    }
}
