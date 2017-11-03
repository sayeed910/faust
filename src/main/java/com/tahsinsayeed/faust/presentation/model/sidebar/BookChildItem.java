package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.google.common.eventbus.EventBus;
import com.tahsinsayeed.faust.presentation.model.BookViewModel;
import javafx.collections.*;

public class BookChildItem implements SideBarItem {
    private final BookViewModel viewModel;
    private String title;

    public BookChildItem(BookViewModel book)
    {
        this.viewModel=book;
        title = book.getName().get();
    }

    @Override
    public ObservableList<SideBarItem> getChildren() {
        return FXCollections.emptyObservableList();
    }
    @Override
    public void onSelected() {
        Bus.getInstance().post(new BookItemSelected(viewModel));
    }
    @Override
    public String toString() {
        return title;
    }

}
