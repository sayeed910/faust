package com.tahsinsayeed.studykit;

import com.tahsinsayeed.studykit.widget.PdfViewer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import sun.rmi.runtime.Log;

import java.util.logging.Logger;

public class Main extends Application {
    private final Logger logger = Logger.getGlobal();

    @Override
    public void start(Stage primaryStage) throws Exception {


        WebView browser = new WebView();
        WebEngine engine = browser.getEngine();
        String viewerPath = getClass().getResource("/web/pdfviewer/viewer.html").toExternalForm();
        logger.info(viewerPath);
        engine.load(viewerPath);
        engine.setOnError(errorEvent-> System.out.println(errorEvent.getMessage()));


        PdfViewerFactory.init();
        Pane root = new VBox();

        Button button = new Button("Load");
        Button button2 = new Button("Debug");

//        WebView browser = new WebView();
//        WebEngine engine = browser.getEngine();
//        engine.load("https://mozilla.github.io/pdf.js/web/viewer.html?file=compressed.tracemonkey-pldi-09.pdf");
//
//        engine.documentProperty().addListener((prop, oldDoc, newDoc) -> enableFirebug(engine));


        PdfViewer view = PdfViewerFactory.get();
        button.setOnAction((value) -> {
            root.getChildren().add(view.getViewer());
            view.loadPdf("C:\\Users\\sayee\\Documents\\Books\\Advanced Java Programming.pdf");
        });

        button2.setOnAction(event ->view.getViewer().getEngine().executeScript("if (!document.getElementById('FirebugLite')){E = document['createElement' + 'NS'] && document.documentElement.namespaceURI;E = E ? document['createElement' + 'NS'](E, 'script') : document['createElement']('script');E['setAttribute']('id', 'FirebugLite');E['setAttribute']('src', 'https://getfirebug.com/' + 'firebug-lite.js' + '#startOpened');E['setAttribute']('FirebugLite', '4');(document['getElementsByTagName']('head')[0] || document['getElementsByTagName']('body')[0]).appendChild(E);E = new Image;E['setAttribute']('src', 'https://getfirebug.com/' + '#startOpened');}")
        );


        root.getChildren().addAll(button, button2);


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
}
