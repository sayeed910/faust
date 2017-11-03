package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.presentation.event.Bus;
import javafx.collections.*;

/**
 * Created by sayeed on 11/3/17.
 */
public class CalendarItem implements SideBarItem {
    @Override
    public ObservableList<SideBarItem> getChildren() {
        return FXCollections.emptyObservableList();
    }

    @Override
    public void onSelected() {
        Bus.get().post(new CalendarItemSelected());
    }

    @Override
    public String toString() {
        return "Calendar";
    }
}
