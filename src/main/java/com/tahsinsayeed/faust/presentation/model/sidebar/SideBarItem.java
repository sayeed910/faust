package com.tahsinsayeed.faust.presentation.model.sidebar;

import javafx.collections.ObservableList;

public interface SideBarItem {
    ObservableList<SideBarItem> getChildren();
}
