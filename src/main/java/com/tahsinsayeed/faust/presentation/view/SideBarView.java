package com.tahsinsayeed.faust.presentation.view;

import com.google.inject.Inject;
import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.presentation.controller.SideBarController;
import com.tahsinsayeed.faust.presentation.model.sidebar.SideBarItem;
import com.tahsinsayeed.faust.ui.RecursiveTreeItem;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class SideBarView extends VBox {
    TreeView<SideBarItem> nav;
    TreeItem<SideBarItem> rootItem;
    Button btnAdd;
    SideBarController controller;
    JFXListView<String> listOfOptions = new JFXListView<>();
    JFXPopup popup = new JFXPopup();

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

        btnAdd = new JFXButton("Add Item");
        btnAdd.prefWidthProperty().bind(this.widthProperty().subtract(-100));
        btnAdd.setStyle("-fx-background-color: #0D47A1; -fx-end-margin: 20px; -fx-start-margin: 20px; -fx-text-fill: white;");
        btnAdd.setFont(Font.font(20));


        this.getChildren().addAll(nav, btnAdd);
        this.setFillWidth(true);
        this.setPrefWidth(400);
        this.setPadding(new Insets(30, 0, 10, 0));
        this.setPadding(new Insets(30, 10, 10, 10));

        nav.getStylesheets().add(getClass().getResource("/css/tree.css").toExternalForm());




        listOfOptions.setItems(FXCollections.observableArrayList("Course", "Assignment", "Exam", "Class", "Book"));
        popup.setPopupContent(listOfOptions);

        listOfOptions.setOnMouseClicked(event -> {
            String selectedItem = listOfOptions.getSelectionModel().getSelectedItem();
            controller.showNewItemDialog(selectedItem);
            popup.hide();
        });

        btnAdd.setOnAction((e) -> popup.show(btnAdd, JFXPopup.PopupVPosition.BOTTOM, JFXPopup.PopupHPosition.RIGHT));

        controller.setNav(nav);
    }


}
