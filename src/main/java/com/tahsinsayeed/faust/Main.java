package com.tahsinsayeed.faust;

import com.google.inject.*;
import com.jfoenix.controls.JFXDecorator;
import com.tahsinsayeed.faust.business.interactor.PopulateDataModelInteractor;
import com.tahsinsayeed.faust.persistence.memory.repository.CourseRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class Main extends Application {
    private final Logger logger = Logger.getGlobal();
    private Scene scene;


    @Override
    public void start(Stage primaryStage) throws Exception {
        PdfViewerFactory.init();

        PopulateDataModelInteractor startupInteractor = new PopulateDataModelInteractor(new CourseRepository());
        startupInteractor.execute(null);

        Injector injector = Guice.createInjector(new FaustModule());



        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Main.fxml"));
        loader.setControllerFactory(injector::getInstance);

        StackPane root = loader.load();


        JFXDecorator decorator = new JFXDecorator(primaryStage, root);


        primaryStage.setTitle("Faust");
        scene = new Scene(decorator, 800, 600);
        scene.getStylesheets().addAll(getClass().getResource("/css/jfoenix-components.css").toExternalForm(),
                getClass().getResource("/css/jfoenix-main-demo.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();


    }



    public static void main(String[] args) {

        launch(args);
//        LauncherImpl.launchApplication(Main.class, FaustPreloader.class, args);
    }



}
