package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.business.dto.*;
import javafx.collections.*;

public class BookChildItem implements SideBarItem {
    private String title;

    public BookChildItem(BookDto bookDto) {
        title = bookDto.getName();
    }

    @Override
    public ObservableList<SideBarItem> getChildren() {
        return FXCollections.emptyObservableList();
    }

    @Override
    public String toString() {
        return title;
    }
}
