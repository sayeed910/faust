package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.presentation.event.Bus;
import javafx.collections.*;

/**
 * Created by sayeed on 11/3/17.
 */
public class RoutineItem implements SideBarItem {
    @Override
    public ObservableList<SideBarItem> getChildren() {
        return FXCollections.emptyObservableList();
    }

    @Override
    public void onSelected() {
        Bus.get().post(new RoutineItemSelected());
    }

    @Override
    public String toString() {
        return "Routine";
    }
}
