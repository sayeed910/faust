package com.tahsinsayeed.faust.presentation.controller;

import com.jfoenix.controls.JFXDialog;
import com.tahsinsayeed.faust.SideBar;
import com.tahsinsayeed.faust.business.dto.DtoBank;
import com.tahsinsayeed.faust.presentation.model.sidebar.*;
import com.tahsinsayeed.faust.presentation.view.partials.*;
import com.tahsinsayeed.faust.ui.RecursiveTreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;

public class SideBarController {
    DtoBank dtoBank = DtoBank.getInstance();
    private SideBarItem rootTreeItem;
    private StackPane stackPane;
    TreeView<SideBarItem> nav = null;

    public SideBarController(StackPane root) {
        rootTreeItem = new CourseItem(dtoBank.getCourses());
        stackPane = root;
    }

    public SideBarItem getRootTreeItem() {
        return rootTreeItem;
    }

    public void showPopup() {

    }

    public void addElement(String item) {
        System.out.println(item);
        PartialView view = null;
        JFXDialog dialog = new JFXDialog();

        if (item.equalsIgnoreCase("course")) {
            view = new AddCourseView(dialog);
        }
        else if(item.equalsIgnoreCase("exam")) {
            view = new AddExamView(dialog);
        }
        else if(item.equalsIgnoreCase("assignment")) {
            view = new AddAssignmentView(dialog);
        }
        else if(item.equalsIgnoreCase("class")) {
            view = new AddClassView(dialog);
        }
        else {
            view = new AddBookView(dialog);
        }
        dialog.setContent(view.getContainer());
        dialog.setDialogContainer(stackPane);
        dialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
        dialog.show();
        dialog.setOnDialogClosed(e->{
            rootTreeItem = new CourseItem(dtoBank.getCourses());
            nav.getRoot().getChildren().clear();
            nav.getRoot().getChildren().add(new RecursiveTreeItem<SideBarItem>(rootTreeItem, SideBarItem::getChildren));
            nav.setShowRoot(false);
        });

    }

    public void setNav(TreeView<SideBarItem> nav) {
        this.nav = nav;
    }
}
