package com.tahsinsayeed.studykit;

import com.tahsinsayeed.studykit.model.Semester;
import com.tahsinsayeed.studykit.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/main_window.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(new GridPane(), 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {

        System.out.println();
        launch(args);
    }
}
