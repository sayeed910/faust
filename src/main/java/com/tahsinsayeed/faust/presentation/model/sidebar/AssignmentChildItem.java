package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.presentation.model.AssignmentViewModel;
import javafx.collections.*;

public class AssignmentChildItem implements SideBarItem {
    private String title;

    public AssignmentChildItem(AssignmentViewModel assignment) {
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
