package com.tahsinsayeed.studykit.controller;

import com.tahsinsayeed.studykit.PdfViewerFactory;
import com.tahsinsayeed.studykit.SideBar;
import com.tahsinsayeed.studykit.model.Semester;
import com.tahsinsayeed.studykit.widget.Notebook;
import com.tahsinsayeed.studykit.widget.PdfViewer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

import java.util.List;

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
                        Notebook notebook = Notebook.create(mainView);
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
//        Button loadNotebook = new Button("Notebook");
//
//        loadNotebook.setOnAction(event -> {
//            Notebook notebook = Notebook.create(mainView);
//            notebook.loadNoteBook();
//        });
//
//
//        button.setOnAction((value) -> {
//        });



    }

}
