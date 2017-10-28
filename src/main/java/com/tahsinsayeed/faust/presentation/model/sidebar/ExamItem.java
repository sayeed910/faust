package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.business.dto.*;
import javafx.collections.*;

import java.util.List;
import java.util.stream.Collectors;

public class ExamItem implements SideBarItem {
    private ObservableList<SideBarItem> children;

    public ExamItem(List<ExamDto> examDtos) {
        children = FXCollections.observableArrayList(
                examDtos.stream()
                        .map(ExamChildItem::new).collect(Collectors.toList())
        );
    }

    @Override
    public ObservableList<SideBarItem> getChildren() {
        return children;
    }
    @Override
    public String toString() {
        return "Exams";
    }
}
