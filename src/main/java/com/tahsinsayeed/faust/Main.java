package com.tahsinsayeed.faust;

import com.jfoenix.controls.*;
import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class Main extends Application {
    private final Logger logger = Logger.getGlobal();


    @Override
    public void start(Stage primaryStage) throws Exception {
        PdfViewerFactory.init();
        VBox root = new VBox();

        TreeView<String> treeView = new JFXTreeView<>();
        treeView.getStylesheets().add(getClass().getResource("/css/list.css").toExternalForm());
        treeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


        TreeItem<String> treeRoot = new TreeItem<>("one");
        treeRoot.getChildren().addAll(
                new TreeItem<>("two"),
                new TreeItem<>("two"),
                new TreeItem<>("two"),
                new TreeItem<>("two")
                );
        treeView.setRoot(treeRoot);
        treeView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    TreeItem<String> item = (TreeItem<String>)newValue;
                    if (!item.isExpanded()) item.setExpanded(true);
                    else item.setExpanded(false);
                } );

        root.getChildren().addAll(treeView);


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
//        LauncherImpl.launchApplication(Main.class, FaustPreloader.class, args);
    }



}
