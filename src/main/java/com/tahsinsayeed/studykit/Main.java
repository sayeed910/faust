package com.tahsinsayeed.studykit;

import com.tahsinsayeed.studykit.model.Course;
import com.tahsinsayeed.studykit.widget.Notebook;
import com.tahsinsayeed.studykit.widget.PdfViewer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXMLLoader;
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        PdfViewerFactory.init();

        Pane root = FXMLLoader.load(getClass().getResource("/view/main_window.fxml"));

//        for (int i = 0; i < semester.courses.lenght; i++) {
//            mainBranch(semester.courses.get(i), root);
//        }
//
//
//        mainBranch(){
//            subbranch(course.)
//        }
//
//        SideBar.getView();
        primaryStage.setTitle("Faust");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.setMaximized(true);
        primaryStage.show();


    }

    private void enableFirebug(WebEngine engine) {
        engine.executeScript("if (!document.getElementById('FirebugLite')){E = document['createElement' + 'NS'] && document.documentElement.namespaceURI;E = E ? document['createElement' + 'NS'](E, 'script') : document['createElement']('script');E['setAttribute']('id', 'FirebugLite');E['setAttribute']('src', 'https://getfirebug.com/' + 'firebug-lite.js' + '#startOpened');E['setAttribute']('FirebugLite', '4');(document['getElementsByTagName']('head')[0] || document['getElementsByTagName']('body')[0]).appendChild(E);E = new Image;E['setAttribute']('src', 'https://getfirebug.com/' + '#startOpened');}");

    }

    public static void main(String[] args) {

        launch(args);
    }



}
