package com.tahsinsayeed.faust;

import com.jfoenix.controls.*;
import com.sun.javafx.application.LauncherImpl;
import com.tahsinsayeed.faust.business.dto.DtoBank;
import com.tahsinsayeed.faust.business.interactor.*;
import com.tahsinsayeed.faust.presentation.controller.SideBarController;
import com.tahsinsayeed.faust.presentation.view.*;
import com.tahsinsayeed.faust.presentation.view.partials.*;
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
    private Scene scene;


    @Override
    public void start(Stage primaryStage) throws Exception {
        PdfViewerFactory.init();
        DtoBank bank = DtoBank.getInstance();
        Interactor startupInteractor = new PopulateDataModelInteractor();
        startupInteractor.execute();
        StackPane root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
//        MainView mainView = new MainView();
//
//        root.getChildren().addAll(mainView.getContainer());

        JFXDecorator decorator = new JFXDecorator(primaryStage, root);


        primaryStage.setTitle("Faust");
        scene = new Scene(decorator, 800, 600);
        scene.getStylesheets().addAll(getClass().getResource("/css/jfoenix-components.css").toExternalForm(),
                getClass().getResource("/css/jfoenix-main-demo.css").toExternalForm());
        primaryStage.setScene(scene);
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
