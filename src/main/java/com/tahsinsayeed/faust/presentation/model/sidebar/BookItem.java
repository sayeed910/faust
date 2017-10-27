package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.business.dto.*;
import javafx.collections.*;

import java.util.List;
import java.util.stream.Collectors;

public class BookItem implements SideBarItem {
    private ObservableList<SideBarItem> children;

    public BookItem(List<BookDto> bookDtos) {
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
    public String toString() {
        return "Books";
    }
}
