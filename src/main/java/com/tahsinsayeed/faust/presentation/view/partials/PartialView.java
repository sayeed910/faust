package com.tahsinsayeed.faust.presentation.view.partials;

import javafx.scene.layout.Pane;

public interface PartialView {
    Pane getContainer();
    void onOk();
    void onCancel();
}
