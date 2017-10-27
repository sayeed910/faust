package com.tahsinsayeed.faust.presentation.controller;

import com.jfoenix.controls.JFXListView;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class ActionPopupController {

    @FXML
    JFXListView toolbarPopupList;

    public void initialize(){

    }

    @FXML
    private void submit() {
        if (toolbarPopupList.getSelectionModel().getSelectedIndex() == 1) {
            Platform.exit();
        }
    }
}
