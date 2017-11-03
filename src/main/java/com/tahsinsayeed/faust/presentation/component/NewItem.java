package com.tahsinsayeed.faust.presentation.component;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.presentation.event.NewItemEvent;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

/**
 * Created by sayeed on 10/27/17.
 */
public class NewItem extends JFXButton {
    private JFXPopup popup;
    private ObservableList<String> items;
    private JFXListView<String> listOfItems;

    @Inject
    EventBus mainEventBus;

    public NewItem(){
        setText("+");
        getStyleClass().add("fab");

        items = FXCollections.observableArrayList("Course", "Exam", "Assignment", "Book", "Note", "Class", "Holiday");
        listOfItems = new JFXListView<>();
        listOfItems.setItems(items);

        popup = new JFXPopup(listOfItems);

        setOnAction(this::showPopup);
        listOfItems.setOnMouseClicked(this::handleItemSelection);


    }

    private void handleItemSelection(MouseEvent mouseEvent) {
        String selectedItem = listOfItems.getSelectionModel().getSelectedItem();
        showNewItemDialog(selectedItem);
        popup.hide();
    }

    private void showNewItemDialog(String selectedItem) {
       mainEventBus.post(new NewItemEvent(selectedItem));
    }

    private void showPopup(ActionEvent actionEvent) {
        popup.show(this, JFXPopup.PopupVPosition.BOTTOM, JFXPopup.PopupHPosition.LEFT, -50, -50);
    }
}
