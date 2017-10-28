package com.tahsinsayeed.faust.presentation.view;

import com.google.inject.Inject;
import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.presentation.controller.SideBarController;
import com.tahsinsayeed.faust.presentation.model.sidebar.SideBarItem;
import com.tahsinsayeed.faust.ui.RecursiveTreeItem;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class SideBarView extends VBox {
    TreeView<SideBarItem> nav;
    TreeItem<SideBarItem> rootItem;
    SideBarController controller;

    @Inject
    public SideBarView(SideBarController aController) {
        System.out.println("initiated side bar view");
        this.controller = aController;
        SideBarItem rootTreeItem = controller.getRootTreeItem();
        rootItem = new RecursiveTreeItem<>(rootTreeItem, SideBarItem::getChildren);
        rootItem.setExpanded(true);

        nav = new JFXTreeView<>(rootItem);
        nav.setShowRoot(false);
        nav.prefHeightProperty().bind(this.heightProperty().subtract(40));
        nav.setBorder(Border.EMPTY);
        nav.setStyle("-fx-background-color: transparent");



        this.getChildren().addAll(nav);
        this.setFillWidth(true);
        this.setPrefWidth(400);
        this.setPadding(new Insets(30, 0, 10, 0));
        this.setPadding(new Insets(30, 10, 10, 10));

        nav.getStylesheets().add(getClass().getResource("/css/tree.css").toExternalForm());

        controller.setNav(nav);
    }


}
