package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.presentation.event.Bus;
import com.tahsinsayeed.faust.presentation.model.AssignmentViewModel;
import javafx.collections.*;

public class AssignmentChildItem implements SideBarItem {
    private final AssignmentViewModel viewModel;
    private String title;


    public AssignmentChildItem(AssignmentViewModel assignment) {
        this.viewModel = assignment;
        title = assignment.getTitle().get();
    }

    @Override
    public ObservableList<SideBarItem> getChildren() {
        return FXCollections.emptyObservableList();
    }

    @Override
    public void onSelected() {
        Bus.get().post(new AssignmentItemSelected(viewModel));
    }

    @Override
    public String toString() {
        return title;
    }
}
