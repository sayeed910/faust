package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.business.dto.*;
import javafx.collections.*;

public class AssignmentChildItem implements SideBarItem {
    private String title;

    public AssignmentChildItem(AssignmentDto assignmentDto) {
        title = assignmentDto.getTitle();
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
