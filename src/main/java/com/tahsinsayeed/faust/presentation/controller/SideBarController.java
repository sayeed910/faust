package com.tahsinsayeed.faust.presentation.controller;

import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.presentation.view.SideBarView;

public class SideBarController {
    SideBarView sideBarView;

    JFXTreeCell<String> cell;

    public void init(){
        cell = new JFXTreeCell<>();
        cell.setItem("one");
        JFXTreeView<String> tree = new JFXTreeView<>();
        tree.setRoot(cell.getTreeItem());
    }
}
