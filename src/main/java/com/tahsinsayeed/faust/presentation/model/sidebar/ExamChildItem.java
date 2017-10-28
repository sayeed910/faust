package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.business.dto.ExamDto;
import javafx.collections.*;

public class ExamChildItem implements SideBarItem {

    private String title;

    public ExamChildItem(ExamDto examDto) {
        title = examDto.getName();
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
