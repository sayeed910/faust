package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.presentation.model.NoteViewModel;
import javafx.collections.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sayeed on 11/3/17.
 */
public class NoteItem implements SideBarItem {
    private ObservableList<SideBarItem> children;

    public NoteItem(List<NoteViewModel> noteViewModels) {
        children = FXCollections.observableArrayList(
                noteViewModels.stream()
                        .map(NoteChildItem::new).collect(Collectors.toList())
        );
    }

    @Override
    public ObservableList<SideBarItem> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Notes";
    }
}
