package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.presentation.model.CourseViewModel;
import javafx.collections.*;

public class CourseChildItem implements SideBarItem {

    private ObservableList<SideBarItem> children;
    private String title;

    public CourseChildItem(CourseViewModel course) {
        title = String.format("%s",course.getName().get());
        children = FXCollections.observableArrayList(
                new AssignmentItem(course.getAssignments()),
                        new ExamItem(course.getExams()),
                        new BookItem(course.getBooks()),
                new NoteItem(course.getNotes()));
    }

    public CourseChildItem(){
        title = "course child";
        children = FXCollections.emptyObservableList();
    }

    @Override
    public ObservableList<SideBarItem> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return title;
    }
}
