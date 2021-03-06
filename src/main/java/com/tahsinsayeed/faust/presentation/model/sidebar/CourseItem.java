package com.tahsinsayeed.faust.presentation.model.sidebar;

import com.tahsinsayeed.faust.presentation.model.CourseViewModel;
import javafx.collections.*;

import java.util.List;
import java.util.stream.Collectors;

public class CourseItem implements SideBarItem {

    private ObservableList<SideBarItem> children;

    public CourseItem(List<CourseViewModel> courses) {
       if (courses.size() == 0) System.out.println("Empty");
        children = FXCollections.observableArrayList(new DashboardItem());
        children.addAll(courses.stream().map(CourseChildItem::new).collect(Collectors.toList()));
        children.addAll(new RoutineItem(), new CalendarItem());
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
        return "Courses";
    }
}
