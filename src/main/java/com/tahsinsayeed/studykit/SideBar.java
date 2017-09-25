package com.tahsinsayeed.studykit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class SaeedBar extends Application{
    Stage window;
    TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Faust");

        TreeItem<String> root,course, CSE_3201, CSE_3202, CSE_3203, CSE_3204, CSE_3205, CSE_3211, CSE_3212, CSE_3213, Schedule;

        //course
        root = new TreeItem<>();
        root.setExpanded(true);

        // maincourse
        course = mainBranch("Course",root);
        Schedule = mainBranch("Schedule",root);

        //CSE_3201
        CSE_3201 = subBranch("CSE_3201", course);
        subBranch("Assignment", CSE_3201);
        subBranch("Exam", CSE_3201);
        subBranch("Book", CSE_3201);
        subBranch("Notebook", CSE_3201);

//CSE_3202
        CSE_3202 = subBranch("CSE_3202", course);
        subBranch("Assignment", CSE_3202);
        subBranch("Exam", CSE_3202);
        subBranch("Book", CSE_3202);
        subBranch("Notebook", CSE_3202);

//CSE_3203
        CSE_3203 = subBranch("CSE_3203", course);
        subBranch("Assignment", CSE_3203);
        subBranch("Exam", CSE_3203);
        subBranch("Book", CSE_3203);
        subBranch("Notebook", CSE_3203);

//CSE_3204
        CSE_3204 = subBranch("CSE_3204", course);
        subBranch("Assignment", CSE_3204);
        subBranch("Exam", CSE_3204);
        subBranch("Book", CSE_3204);
        subBranch("Notebook", CSE_3204);

//CSE_3205
        CSE_3205 = subBranch("CSE_3205", course);
        subBranch("Assignment", CSE_3205);
        subBranch("Exam", CSE_3205);
        subBranch("Book", CSE_3205);
        subBranch("Notebook", CSE_3205);

//CSE_3211
        CSE_3211 = subBranch("CSE_3211", course);
        subBranch("Assignment", CSE_3211);
        subBranch("Exam", CSE_3211);
        subBranch("Book", CSE_3211);
        subBranch("Notebook", CSE_3211);

        //CSE_3212
        CSE_3212 = subBranch("CSE_3212", course);
        subBranch("Assignment", CSE_3212);
        subBranch("Exam", CSE_3212);
        subBranch("Book", CSE_3212);
        subBranch("Notebook", CSE_3212);


        //Megan
//CSE_3213
        CSE_3213 = subBranch("CSE_3213", course);
        subBranch("Assignment", CSE_3213);
        subBranch("Exam", CSE_3213);
        subBranch("Book", CSE_3213);
        subBranch("Notebook", CSE_3213);


        //Create the tree and hide the main course
        tree = new TreeView<>(root);
        //tree = new TreeView<>(course);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if (newValue != null)
                        System.out.println(newValue.getValue());
                });

        //Layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout, 600, 650);
        window.setScene(scene);
        window.show();
    }

    //Create branches
    public TreeItem<String> subBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(false);
        parent.getChildren().add(item);
        return item;
    }
    public TreeItem<String> mainBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }



}
