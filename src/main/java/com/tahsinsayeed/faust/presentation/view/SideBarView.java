package com.tahsinsayeed.faust.presentation.view;

import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.presentation.controller.SideBarController;
import com.tahsinsayeed.faust.presentation.model.sidebar.SideBarItem;
import com.tahsinsayeed.faust.ui.RecursiveTreeItem;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

public class SideBarView implements View {

    StackPane root;
    VBox container;
    TreeView<SideBarItem> nav;
    TreeItem<SideBarItem> rootItem;
    TreeView<String> test;
    TreeItem<String> testRoot;
    Button btnAdd;
    SideBarController controller;
    JFXListView<String> listOfOptions = new JFXListView<>();
    JFXPopup popup = new JFXPopup();

    public SideBarView(SideBarController aController){
        this.controller = aController;
        SideBarItem rootTreeItem = controller.getRootTreeItem();
        rootItem = new RecursiveTreeItem<>(rootTreeItem, SideBarItem::getChildren);
        nav = new JFXTreeView<>(rootItem);
        nav.setShowRoot(false);
        rootItem.setExpanded(true);
        btnAdd = new JFXButton("Add Item");
        container = new VBox(nav, btnAdd);
        nav.prefHeightProperty().bind(getContainer().heightProperty().subtract(40));
        nav.setBorder(Border.EMPTY);
        nav.setStyle("-fx-background-color: transparent");
        btnAdd.prefWidthProperty().bind(getContainer().widthProperty());
        btnAdd.setOnAction((e)->controller.showPopup());
        container.setFillWidth(true);
        container.setPrefWidth(400);
        container.setPadding(new Insets(30, 0, 10, 0));
        root = new StackPane(container);


        listOfOptions.setItems(FXCollections.observableArrayList("Course", "Assignment", "Exam", "Class", "Book"));
        popup.setPopupContent(listOfOptions);

        listOfOptions.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            controller.addElement(newValue);
        });

    }


    @Override
    public Pane getContainer() {
        return container;
    }
}
