package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.business.dto.AssignmentDto;
import javafx.collections.*;

import java.util.List;
import java.util.stream.Collectors;

public class AssignmentItem implements SideBarItem {
    private ObservableList<SideBarItem> children;

    public AssignmentItem(List<AssignmentDto> assignmentDtos) {
        children = FXCollections.observableArrayList(
                assignmentDtos.stream()
                        .map(AssignmentChildItem::new).collect(Collectors.toList())
        );
    }

    @Override
    public ObservableList<SideBarItem> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Assignments";
    }
}
