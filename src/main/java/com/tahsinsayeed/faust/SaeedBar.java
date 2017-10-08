package com.tahsinsayeed.faust;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class SaeedBar extends Application{
    Stage window;
    TreeView<String> tree,tree2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Faust");

        TreeItem<String> course, CSE_3201, CSE_3202, CSE_3203, CSE_3204, CSE_3205, CSE_3211, CSE_3212, CSE_3213, another,Schedule;
        VBox vb;
        HBox hb;
        Button button=new Button("Add Course");
        vb = new VBox();
        hb =new HBox();

        //course
        course = new TreeItem<>();
        course.setExpanded(true);

        // Schedule
        another = new TreeItem<>();
        another.setExpanded(true);
        Schedule = mainBranch("Schedule",another);

        //CSE_3201
        CSE_3201 = subBranch("CSE_3201", course);
        subBranch("Assignment", CSE_3201);
        subBranch("Exam", CSE_3201);
        subBranch("Book", CSE_3201);
        subBranch("Note", CSE_3201);

//CSE_3202
        CSE_3202 = subBranch("CSE_3202", course);
        subBranch("Assignment", CSE_3202);
        subBranch("Exam", CSE_3202);
        subBranch("Book", CSE_3202);
        subBranch("Note", CSE_3202);

//CSE_3203
        CSE_3203 = subBranch("CSE_3203", course);
        subBranch("Assignment", CSE_3203);
        subBranch("Exam", CSE_3203);
        subBranch("Book", CSE_3203);
        subBranch("Note", CSE_3203);

//CSE_3204
        CSE_3204 = subBranch("CSE_3204", course);
        subBranch("Assignment", CSE_3204);
        subBranch("Exam", CSE_3204);
        subBranch("Book", CSE_3204);
        subBranch("Note", CSE_3204);

//CSE_3205
        CSE_3205 = subBranch("CSE_3205", course);
        subBranch("Assignment", CSE_3205);
        subBranch("Exam", CSE_3205);
        subBranch("Book", CSE_3205);
        subBranch("Note", CSE_3205);

//CSE_3211
        CSE_3211 = subBranch("CSE_3211", course);
        subBranch("Assignment", CSE_3211);
        subBranch("Exam", CSE_3211);
        subBranch("Book", CSE_3211);
        subBranch("Note", CSE_3211);

        //CSE_3212
        CSE_3212 = subBranch("CSE_3212", course);
        subBranch("Assignment", CSE_3212);
        subBranch("Exam", CSE_3212);
        subBranch("Book", CSE_3212);
        subBranch("Note", CSE_3212);


        //Megan
//CSE_3213
        CSE_3213 = subBranch("CSE_3213", course);
        subBranch("Assignment", CSE_3213);
        subBranch("Exam", CSE_3213);
        subBranch("Book", CSE_3213);
        subBranch("Note", CSE_3213);
// Add Assignment
        ComboBox Assginment;
        Assginment = new ComboBox<>();
        Assginment.getItems().addAll(
                "CSE_3201",
                "CSE_3202",
                "CSE_3203",
                "CSE_3204",
                "CSE_3205"
        );


        Assginment.setPromptText("Add Assignment");

        // Add Assignment
        ComboBox Exam;
        Exam = new ComboBox<>();
        Exam.getItems().addAll(
                "CSE_3201",
                "CSE_3202",
                "CSE_3203",
                "CSE_3204",
                "CSE_3205"
        );


        Exam.setPromptText("Add Exam");

        // Add Assignment
        ComboBox Book;
        Book = new ComboBox<>();
        Book.getItems().addAll(
                "CSE_3201",
                "CSE_3202",
                "CSE_3203",
                "CSE_3204",
                "CSE_3205"
        );


        Book.setPromptText("Add Book");

// Add Note
        ComboBox Notebook;
        Notebook = new ComboBox<>();
        Notebook.getItems().addAll(
                "CSE_3201",
                "CSE_3202",
                "CSE_3203",
                "CSE_3204",
                "CSE_3205"
        );


        Notebook.setPromptText("Add Note");

// Bind all of them in a Vbox

        VBox bind = new VBox();
        bind.getChildren().addAll(Assginment,Exam,Book,Notebook,button);


        //Create the tree and hide the main course
        tree = new TreeView<>(course);
        tree2=new TreeView<>(Schedule);
        //tree = new TreeView<>(course);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if (newValue != null)
                        System.out.println(newValue.getValue());
                });

        //Layout
        StackPane layout = new StackPane();
        //vb.getChildren().add (root,course);
        layout.getChildren().add(vb);
        vb.getChildren().add (hb);
        hb.getChildren().add (tree);
        hb.getChildren().add (bind);
        vb.getChildren().add (tree2);
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
