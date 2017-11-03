package com.tahsinsayeed.faust.presentation.model.sidebar;

import javafx.collections.*;

/**
 * Created by sayeed on 11/3/17.
 */
public class SemesterItem implements SideBarItem {
    private ObservableList<SideBarItem> children;
    @Override
    public ObservableList<SideBarItem> getChildren() {
        return children;
    }

    public SemesterItem(CourseItem courseItem){
        children = FXCollections.observableArrayList(new DashboardItem(), courseItem, new RoutineItem(), new CalendarItem());
    }

    @Override
    public void onSelected() {

    }

    @Override
    public String toString() {
        return "Semester";
    }
}
