package com.tahsinsayeed.faust.presentation.controller;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.presentation.model.sidebar.*;
import com.tahsinsayeed.faust.ui.RecursiveTreeItem;
import javafx.collections.*;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;

public class SideBarController {

    private SideBarItem rootTreeItem;
    private StackPane root;
    TreeView<SideBarItem> nav;
    ObservableList<CourseDto> courses;

    @Inject
    EventBus mainEventBus;


    public SideBarController() {
        System.out.println("initiated sidebar controller");
        courses = DtoBank.getInstance().getCourses();
        rootTreeItem = new CourseItem(courses);

        courses.addListener(this::updateTree);
    }

    private void updateTree(ListChangeListener.Change<? extends CourseDto> change) {
        change.next();

        if (change.wasAdded()) {
            SideBarItem newItem = new CourseChildItem(change.getAddedSubList().get(0));
            nav.getRoot().getChildren().add(new RecursiveTreeItem<>(newItem, SideBarItem::getChildren));
        } else if (change.wasUpdated()){
            for (int i = change.getFrom(); i < change.getTo(); i++) {
                nav.getRoot().getChildren().remove(i);
            }
        }

    }

    public SideBarItem getRootTreeItem() {
        return rootTreeItem;
    }

    public void showNewItemDialog(String item) {
        mainEventBus.post(item);
    }

    public void setNav(TreeView<SideBarItem> nav) {
        this.nav = nav;
    }
}
