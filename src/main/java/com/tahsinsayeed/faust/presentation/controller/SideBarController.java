package com.tahsinsayeed.faust.presentation.controller;

import com.google.inject.Inject;
import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.presentation.EntityCreatorFactory;
import com.tahsinsayeed.faust.presentation.model.sidebar.*;
import com.tahsinsayeed.faust.presentation.view.EntityCreationView;
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
    EntityCreatorFactory entityCreatorFactory;


    public SideBarController(StackPane root) {
        courses = DtoBank.getInstance().getCourses();
        rootTreeItem = new CourseItem(courses);
        this.root = root;

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
        EntityCreationView view = entityCreatorFactory.create(item);
        view.showDialog(root);
    }

    public void setNav(TreeView<SideBarItem> nav) {
        this.nav = nav;
    }
}
