package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.presentation.model.ExamViewModel;
import javafx.collections.*;

public class ExamChildItem implements SideBarItem {

    private String title;

    public ExamChildItem(ExamViewModel exam) {
        title = exam.getName().get();
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
