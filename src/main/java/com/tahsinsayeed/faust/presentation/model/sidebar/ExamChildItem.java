package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.google.common.eventbus.EventBus;
import com.tahsinsayeed.faust.business.entity.Exam;
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
        Bus.getInstance().post(new ExamItemSelected(viewModel));
    }
    @Override
    public String toString() {
        return title;
    }
}
