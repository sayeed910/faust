package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.presentation.model.ExamViewModel;
import javafx.collections.*;

import java.util.List;
import java.util.stream.Collectors;

public class ExamItem implements SideBarItem {
    private ObservableList<SideBarItem> children;

    public ExamItem(List<ExamViewModel> exams) {
        children = FXCollections.observableArrayList(
                exams.stream()
                        .map(ExamChildItem::new).collect(Collectors.toList())
        );
    }

    @Override
    public ObservableList<SideBarItem> getChildren() {
        return children;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public String toString() {
        return "Exams";
    }
}
