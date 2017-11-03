package com.tahsinsayeed.faust.presentation.controller;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.tahsinsayeed.faust.presentation.model.*;
import com.tahsinsayeed.faust.presentation.model.sidebar.*;
import javafx.collections.*;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;

import java.util.stream.Collectors;

public class SideBarController {

    private SideBarItem rootTreeItem;
    private StackPane root;
    TreeView<SideBarItem> nav;
    ObservableList<CourseViewModel> courses;

    @Inject
    EventBus mainEventBus;


    public SideBarController() {
        System.out.println("initiated sidebar controller");
        courses = ViewModelStorage.getInstance().getCourses();
        rootTreeItem = new CourseItem(courses);

        courses.addListener(this::updateTree);
    }

    private void updateTree(ListChangeListener.Change<? extends CourseViewModel> change) {
        rootTreeItem.getChildren().clear();
        rootTreeItem.getChildren().add(new DashboardItem());
        rootTreeItem.getChildren().addAll(courses.stream().map(CourseChildItem::new).collect(Collectors.toList()));
        rootTreeItem.getChildren().addAll(new RoutineItem(), new CalendarItem());
    }

    public SideBarItem getRootTreeItem() {
        return rootTreeItem;
    }



    public void setNav(TreeView<SideBarItem> nav) {
        this.nav = nav;
    }
}
