package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.presentation.model.BookViewModel;
import javafx.collections.*;

import java.util.List;
import java.util.stream.Collectors;

public class BookItem implements SideBarItem {
    private ObservableList<SideBarItem> children;

    public BookItem(List<BookViewModel> bookDtos) {
        children = FXCollections.observableArrayList(
                bookDtos.stream()
                        .map(BookChildItem::new).collect(Collectors.toList())
        );
    }

    @Override
    public ObservableList<SideBarItem> getChildren() {
        return children;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public String toString() {
        return "Books";
    }
}
