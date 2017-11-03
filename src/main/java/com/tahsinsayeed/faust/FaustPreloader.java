package com.tahsinsayeed.faust;
import com.jfoenix.controls.JFXSpinner;
import javafx.application.Preloader;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.*;

/**
 * Created by Shamim
 */
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
        Label loading= new Label("Loading");
        loading.setFont(Font.font("Cambria", 32));
        loading.setTextFill(Color.web("#EEEA13"));
        //loading.setTextFill(Color.MAGENTA);


        //loading.setTextFill(Color.web("#0076a3"));
        //spinner.resize(20,20);

        VBox vbox2;
        vbox2 = new VBox(spinner,loading);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setSpacing(5);
        VBox vbox= new VBox(imageView,vbox2);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(00);
        vbox.setBackground(new Background(new BackgroundFill(Color.web("#070C6F"), CornerRadii.EMPTY, Insets.EMPTY)));
        return new Scene(vbox, 700, 450);
    }



    @Override
    public void start(Stage Stage) throws Exception {

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
                System.out.println( "BEFORE_LOAD");
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

