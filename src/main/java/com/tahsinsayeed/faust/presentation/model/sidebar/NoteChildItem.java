package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.google.common.eventbus.EventBus;
import com.tahsinsayeed.faust.presentation.model.NoteViewModel;
import javafx.collections.*;

/**
 * Created by sayeed on 11/3/17.
 */
public class NoteChildItem implements SideBarItem {
    private final NoteViewModel viewModel;
    private String title;

    public NoteChildItem(NoteViewModel note)
    {
        this.viewModel= note;
        title = note.getTitle().get();
    }

    @Override
    public ObservableList<SideBarItem> getChildren() {
        return FXCollections.emptyObservableList();
    }
    @Override
    public void onSelected() {
        Bus.getInstance().post(new NoteItemSelected(viewModel));
    }
    @Override
    public String toString() {
        return title;
    }
}
