package com.tahsinsayeed.studykit;

import javafx.application.Application;
import javafx.collections.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class SideBar {
    Pane pane;
    TreeView<String> tree;

    public SideBar(Pane pane) {
        this.pane = pane;
        displaySideBar();
//        TreeView<String> tree = FXMLLoader.load(getClass().getResource("/view/main_window.fxml").toExternalForm());
    }

    public TreeView<String> getTree() {
        ObservableList<String> items = FXCollections.observableArrayList("Course", "Books");

        ListView<String> list = new ListView<String>(items);
        list.setOnMouseClicked((event)->{
            String selected = list.getSelectionModel().getSelectedItem();

            if (selected.equalsIgnoreCase("course")){

            }


        });
        return tree;
    }

    public  void displaySideBar() {
        TreeItem<String> root,course, CSE_3201, CSE_3202, CSE_3203, CSE_3204, CSE_3205, CSE_3211, CSE_3212, CSE_3213, Schedule;

        //course
        root = new TreeItem<>();
        root.setExpanded(false);

        // maincourse
//        course = mainBranch("Course",root);


        //CSE_3201
        CSE_3201 = mainBranch("CSE_3201", root);
        subBranch("Assignment", CSE_3201);
        subBranch("Exam", CSE_3201);
        subBranch("Book", CSE_3201);
        subBranch("Notebook", CSE_3201);

//CSE_3202
        CSE_3202 = mainBranch("CSE_3202", root);
        subBranch("Assignment", CSE_3202);
        subBranch("Exam", CSE_3202);
        subBranch("Book", CSE_3202);
        subBranch("Notebook", CSE_3202);

//CSE_3203
        CSE_3203 = mainBranch("CSE_3203", root);
        subBranch("Assignment", CSE_3203);
        subBranch("Exam", CSE_3203);
        subBranch("Book", CSE_3203);
        subBranch("Notebook", CSE_3203);

//CSE_3204
        CSE_3204 = mainBranch("CSE_3204", root);
        subBranch("Assignment", CSE_3204);
        subBranch("Exam", CSE_3204);
        subBranch("Book", CSE_3204);
        subBranch("Notebook", CSE_3204);

//CSE_3205
        CSE_3205 = mainBranch("CSE_3205", root);
        subBranch("Assignment", CSE_3205);
        subBranch("Exam", CSE_3205);
        subBranch("Book", CSE_3205);
        subBranch("Notebook", CSE_3205);

//CSE_3211
        CSE_3211 = mainBranch("CSE_3211", root);
        subBranch("Assignment", CSE_3211);
        subBranch("Exam", CSE_3211);
        subBranch("Book", CSE_3211);
        subBranch("Notebook", CSE_3211);

        //CSE_3212
        CSE_3212 = mainBranch("CSE_3212", root);
        subBranch("Assignment", CSE_3212);
        subBranch("Exam", CSE_3212);
        subBranch("Book", CSE_3212);
        subBranch("Notebook", CSE_3212);


        //Megan
//CSE_3213
        CSE_3213 = mainBranch("CSE_3213", root);
        subBranch("Assignment", CSE_3213);
        subBranch("Exam", CSE_3213);
        subBranch("Book", CSE_3213);
        subBranch("Notebook", CSE_3213);

        Schedule = mainBranch("Schedule",root);
        //Create the tree and hide the main root
        tree = new TreeView<>(root);
        //tree = new TreeView<>(course);
        tree.setShowRoot(false);
        pane.getChildren().add(tree);

    }

    //Create branches
    private  TreeItem<String> subBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(false);
        parent.getChildren().add(item);
        return item;
    }
    private  TreeItem<String> mainBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(false);
        parent.getChildren().add(item);
        return item;
    }



}
