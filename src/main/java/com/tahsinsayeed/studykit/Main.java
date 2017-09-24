package com.tahsinsayeed.studykit;

import com.tahsinsayeed.studykit.widget.Notebook;
import com.tahsinsayeed.studykit.widget.PdfViewer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

import java.util.logging.Logger;

public class Main extends Application {
    private final Logger logger = Logger.getGlobal();
    public final App app = new App();

    @Override
    public void start(Stage primaryStage) throws Exception {

        PdfViewerFactory.init();
        Pane root = new VBox();

        Button button = new Button("Load");
        Button button2 = new Button("Debug");
        Button loadNotebook = new Button("Notebook");
        WebView notebookView = new WebView();

        loadNotebook.setOnAction(event -> {
            root.getChildren().add(notebookView);
            Notebook notebook = Notebook.create(notebookView);
            notebook.loadNoteBook();
        });

        PdfViewer view = PdfViewerFactory.get();
        button.setOnAction((value) -> {
            root.getChildren().add(view.getViewer());
            view.loadPdf("C:\\Users\\sayee\\Documents\\Books\\Advanced Java Programming.pdf");
        });





//        button2.setOnAction(event ->enableFirebug(view.getViewer().getEngine()));
        button2.setOnAction(event -> notebookView.getEngine().executeScript("test()"));

        root.getChildren().addAll(loadNotebook,button, button2);


        primaryStage.setTitle("Study Kit");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }

    private void enableFirebug(WebEngine engine) {
        engine.executeScript("if (!document.getElementById('FirebugLite')){E = document['createElement' + 'NS'] && document.documentElement.namespaceURI;E = E ? document['createElement' + 'NS'](E, 'script') : document['createElement']('script');E['setAttribute']('id', 'FirebugLite');E['setAttribute']('src', 'https://getfirebug.com/' + 'firebug-lite.js' + '#startOpened');E['setAttribute']('FirebugLite', '4');(document['getElementsByTagName']('head')[0] || document['getElementsByTagName']('body')[0]).appendChild(E);E = new Image;E['setAttribute']('src', 'https://getfirebug.com/' + '#startOpened');}");

    }

    public static void main(String[] args) {

        System.out.println();
        launch(args);
    }

    public class App {
        int i = 0;
        public void callFromJavascript(){
            System.out.println("Called from javascript" + ++i);
        }
    }


}
