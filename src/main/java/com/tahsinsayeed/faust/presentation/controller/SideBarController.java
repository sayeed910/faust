package com.tahsinsayeed.faust.presentation.controller;

import com.tahsinsayeed.faust.business.dto.DtoBank;
import com.tahsinsayeed.faust.presentation.model.sidebar.*;

public class SideBarController {
    DtoBank dtoBank = DtoBank.getInstance();
    private SideBarItem rootTreeItem;

    public SideBarController() {
        rootTreeItem = new CourseItem(dtoBank.getCourses());
    }

    public SideBarItem getRootTreeItem() {
        return rootTreeItem;
    }

    public void showPopup() {

    }

    public void addElement(String item) {

    }
}
