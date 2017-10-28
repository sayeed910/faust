package com.tahsinsayeed.faust;

import com.jfoenix.controls.JFXSpinner;
import com.sun.org.apache.regexp.internal.REDebugCompiler;
import javafx.application.Preloader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Preloader;
import javafx.scene.control.Label;

import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;

import static java.awt.image.ImageObserver.HEIGHT;

public class FaustPreloader extends Preloader {

    ProgressBar bar;
    Stage stage;
    private JFXSpinner spinner;
    //Stage.Transparency=0;

    private Scene createPreloaderScene() {
        bar = new ProgressBar();

        // BorderPane p = new BorderPane();

        spinner = new JFXSpinner();
        spinner.setRadius(10);
        spinner.setVisible(false);
        Image image = new Image("logo.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(300);
        imageView.setFitWidth(280);
        Label loading = new Label("Loading");
        loading.setFont(Font.font("Cambria", 32));
        loading.setTextFill(Color.web("#EEEA13"));
        //loading.setTextFill(Color.MAGENTA);


        //loading.setTextFill(Color.web("#0076a3"));
        //spinner.resize(20,20);

        VBox vbox2;
        vbox2 = new VBox(spinner, loading);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setSpacing(5);
        VBox vbox = new VBox(imageView, vbox2);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(00);
        vbox.setBackground(new Background(new BackgroundFill(Color.web("#070C6F"), CornerRadii.EMPTY, Insets.EMPTY)));
        return new Scene(vbox, 700, 450);
    }


  /*  public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setScene(createPreloaderScene());
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        // for(int i=0;i<1000000;i++);
        //spinner.setVisible(true);
        stage.show();
    }*/

    /*  @Override
      public void init() throws Exception {
  //        System.out.println(MyApplication.STEP() + "MyPreloader#init (could be used to initialize preloader view), thread: " + Thread.currentThread().getName());

          // If preloader has complex UI it's initialization can be done in MyPreloader#init
          Platform.runLater(() -> {
              Label title = new Label("Showing preloader stage!\nLoading, please wait...");
              title.setTextAlignment(TextAlignment.CENTER);
              progress = new Label("0%");

              VBox root = new VBox(title, progress);
              root.setAlignment(Pos.CENTER);

              scene = new Scene(root, WIDTH, HEIGHT);
          });
      }
  */
    @Override
    public void start(Stage Stage) throws Exception {
//        System.out.println(MyApplication.STEP() + "MyPreloader#start (showing preloader stage), thread: " + Thread.currentThread().getName());

        this.stage = Stage;

        // Set preloader scene and show stage.
        stage.setScene(createPreloaderScene());
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification info) {
        // Handle application notification in this point (see MyApplication#init).
        if (info instanceof ProgressNotification) {
            //  progress.setText(((ProgressNotification) info).getProgress() + "%");
        }
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        // Handle state change notifications.
        StateChangeNotification.Type type = info.getType();
        switch (type) {
            case BEFORE_LOAD:
                spinner.setVisible(false);
                // Called after MyPreloader#start is called.
                System.out.println("BEFORE_LOAD");
                break;
            case BEFORE_INIT:
                spinner.setVisible(true);
                // Called before MyApplication#init is called.
                System.out.println("BEFORE_INIT");
                break;
            case BEFORE_START:
                // Called after MyApplication#init and before MyApplication#start is called.
//                System.out.println(MyApplication.STEP() + "BEFORE_START");

                stage.hide();
                break;
        }
    }
}

