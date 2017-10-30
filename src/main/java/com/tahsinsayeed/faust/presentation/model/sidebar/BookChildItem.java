package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.presentation.model.BookViewModel;
import javafx.collections.*;

public class BookChildItem implements SideBarItem {
    private String title;

    public BookChildItem(BookViewModel book) {
        title = book.getName().get();
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
