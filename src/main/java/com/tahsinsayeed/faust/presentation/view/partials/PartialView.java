package com.tahsinsayeed.faust.presentation.view.partials;

import com.tahsinsayeed.faust.presentation.view.View;
import javafx.scene.layout.Pane;

public interface PartialView extends View {
    void onOk();
    void onCancel();
}
