package com.tahsinsayeed.faust.presentation.view;

import com.jfoenix.controls.JFXDialog;
import javafx.scene.layout.*;

public abstract class EntityCreationDialog {
    protected JFXDialog dialog = new JFXDialog();

    public void showDialog(StackPane root){
        dialog.setDialogContainer(root);
        dialog.setContent(getContent());
        dialog.show();
    }

    protected abstract Pane getContent();
}
