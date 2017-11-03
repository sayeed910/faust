package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.presentation.model.NoteViewModel;
import javafx.collections.*;

/**
 * Created by sayeed on 11/3/17.
 */
public class NoteChildItem implements SideBarItem {
    private String title;

    public NoteChildItem(NoteViewModel assignment) {
        title = assignment.getTitle().get();
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
