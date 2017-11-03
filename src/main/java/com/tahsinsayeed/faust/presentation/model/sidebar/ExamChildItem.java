package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.presentation.event.Bus;
import com.tahsinsayeed.faust.presentation.event.ExamItemSelected;
import com.tahsinsayeed.faust.presentation.model.ExamViewModel;
import javafx.collections.*;

public class ExamChildItem implements SideBarItem {

    private final ExamViewModel viewModel;
    private String title;

    public ExamChildItem(ExamViewModel exam) {
        this.viewModel=exam;
        title = exam.getName().get();
    }

    @Override
    public ObservableList<SideBarItem> getChildren() {
        return FXCollections.emptyObservableList();
    }
    @Override
    public void onSelected() {
        Bus.get().post(new ExamItemSelected(viewModel));
    }
    @Override
    public String toString() {
        return title;
    }
}
