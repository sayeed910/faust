package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.business.dto.CourseDto;
import javafx.collections.*;

public class CourseChildItem implements SideBarItem {

    private ObservableList<SideBarItem> children;
    private String title;

    public CourseChildItem(CourseDto courseDto) {
        title = String.format("%s",courseDto.getName());
        children = FXCollections.observableArrayList(
                new AssignmentItem(courseDto.getAssignments()),
                        new ExamItem(courseDto.getExams()),
                        new BookItem(courseDto.getBooks()));
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
