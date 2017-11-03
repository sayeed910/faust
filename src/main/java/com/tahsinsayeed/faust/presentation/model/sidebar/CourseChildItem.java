package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.google.common.eventbus.EventBus;
import com.tahsinsayeed.faust.presentation.event.Bus;
import com.tahsinsayeed.faust.presentation.event.CourseItemSelected;
import com.tahsinsayeed.faust.presentation.model.CourseViewModel;
import com.tahsinsayeed.faust.presentation.view.CourseView;
import javafx.collections.*;

public class CourseChildItem implements SideBarItem {
    private ObservableList<SideBarItem> children;
    private final CourseViewModel viewModel;
    private String title;

    public CourseChildItem(CourseViewModel course) {
        this.viewModel=course;
        title = String.format("%s",course.getName().get());
        children = FXCollections.observableArrayList(
                new AssignmentItem(course.getAssignments()),
                        new ExamItem(course.getExams()),
                        new BookItem(course.getBooks()),
                new NoteItem(course.getNotes()));
    }


    @Override
    public ObservableList<SideBarItem> getChildren() {
        return children;
    }
    @Override
    public void onSelected() {
        Bus.get().post(new CourseItemSelected(viewModel));
    }

    @Override
    public String toString() {
        return title;
    }
}
