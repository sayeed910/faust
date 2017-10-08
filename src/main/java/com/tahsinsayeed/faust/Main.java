package com.tahsinsayeed.faust;

import com.jfoenix.controls.*;
import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class Main extends Application {
    private final Logger logger = Logger.getGlobal();

    @Override
    public void init(){
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PdfViewerFactory.init();

//        Pane defaul = FXMLLoader.load(getClass().getResource("/view/main_window.fxml"));
//        JFXDecorator root = new JFXDecorator(primaryStage, defaul);
//        root.setCustomMaximize(true);

        VBox root = new VBox();
        JFXDatePicker blueDatePicker = new JFXDatePicker();
        blueDatePicker.setDefaultColor(Color.valueOf("#3f51b5"));
        blueDatePicker.setOverLay(true);
        StackPane pane = new StackPane();
        blueDatePicker.setDialogParent(pane);
//        root.getChildren().addAll(blueDatePicker);

        JFXListView<Label> list = new JFXListView<Label>();
        for(int i = 0 ; i < 4 ; i++) list.getItems().add(new Label("Item " + i));
        list.getStyleClass().add("mylistview");
        root.getChildren().addAll(list);

        primaryStage.setTitle("Faust");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.setMaximized(true);
        primaryStage.show();


    }

    private void enableFirebug(WebEngine engine) {
        engine.executeScript("if (!document.getElementById('FirebugLite')){E = document['createElement' + 'NS'] && document.documentElement.namespaceURI;E = E ? document['createElement' + 'NS'](E, 'script') : document['createElement']('script');E['setAttribute']('id', 'FirebugLite');E['setAttribute']('src', 'https://getfirebug.com/' + 'firebug-lite.js' + '#startOpened');E['setAttribute']('FirebugLite', '4');(document['getElementsByTagName']('head')[0] || document['getElementsByTagName']('body')[0]).appendChild(E);E = new Image;E['setAttribute']('src', 'https://getfirebug.com/' + '#startOpened');}");

    }

    public static void main(String[] args) {

//        launch(args);
        LauncherImpl.launchApplication(Main.class, FaustPreloader.class, args);
    }



}
