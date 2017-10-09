package com.tahsinsayeed.faust.presentation.controller;

import com.tahsinsayeed.faust.PdfViewerFactory;
import com.tahsinsayeed.faust.SideBar;
import com.tahsinsayeed.faust.widget.*;
import com.tahsinsayeed.faust.widget.TextEditor;
import javafx.fxml.FXML;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

public class MainWindowController {

    @FXML
    WebView mainView;
    @FXML
    VBox nav;
    @FXML
    VBox center;
    @FXML
    BorderPane root;
    public void initialize(){

        SideBar menu = new SideBar(nav);
        TreeView<String> tree = menu.getTree();
        PdfViewer view = PdfViewerFactory.get();

        center.setFillWidth(true);
        center.prefHeightProperty().bind(root.heightProperty());





//        menu.displaySideBar();
        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if (newValue.getValue().equalsIgnoreCase("notebook")){
                        center.getChildren().clear();
                        center.getChildren().add(mainView);
                        TextEditor notebook = TextEditor.create(mainView);
                        notebook.loadNoteBook();
                    } else if(newValue.getValue().equalsIgnoreCase("Book")){
                        System.out.println("book selected");
                        center.getChildren().clear();
                        center.getChildren().add(view.getViewer());

                        view.loadPdf("C:\\Users\\sayee\\Documents\\Books\\Advanced Java Programming.pdf");
                    }

                });



//        Button button = new Button("Load");
//
//        Button loadNotebook = new Button("Note");
//
//        loadNotebook.setOnAction(events -> {
//            Note notebook = Note.create(mainView);
//            notebook.loadNoteBook();
//        });
//
//
//        button.setOnAction((value) -> {
//        });



    }

}
