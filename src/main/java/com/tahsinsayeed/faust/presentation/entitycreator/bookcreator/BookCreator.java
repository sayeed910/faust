package com.tahsinsayeed.faust.presentation.entitycreator.bookcreator;

        import com.jfoenix.controls.*;
        import com.jfoenix.validation.*;
        import com.tahsinsayeed.faust.presentation.view.EntityCreationDialog;
        import com.tahsinsayeed.faust.ui.component.FloatingTextField;
        import javafx.collections.FXCollections;
        import javafx.geometry.*;
        import javafx.scene.control.*;
        import javafx.scene.layout.*;
        import javafx.scene.paint.Paint;
        import javafx.scene.text.Font;
        import javafx.stage.FileChooser;

        import java.util.List;

/**
 * Created by Shamim on 10/28/17.
 */

public class BookCreator extends EntityCreationDialog{
    private final JFXComboBox<String> txtParentCourseId;
    VBox container = new VBox();
    BorderPane pane = new BorderPane();
    private final JFXTextField nameInput;
    private final FileChooser fileChooser;
    private final JFXTextField filePath;
    private final HBox bottomContainer;
    private Button btnOk;
    private Label error;
    private final BookCreationController controller;


    public BookCreator(List<String> existingCourseIds, BookCreationController controller){
        this.controller = controller;

        Label title = new Label("New Book");
        title.setFont(Font.font(20));
        title.setPadding(new Insets(10, 10, 30, 10));

        nameInput = FloatingTextField.withPromptText("Book Name");
        nameInput.setValidators(new RequiredFieldValidator());





        fileChooser = new FileChooser();
        fileChooser.setTitle("Select Book");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));

        filePath = new JFXTextField();
        filePath.setPromptText("Choose File");
        filePath.setEditable(false);
        filePath.setOnAction(e -> filePath.setText(fileChooser.showOpenDialog(null).getAbsolutePath()) );

        txtParentCourseId = new JFXComboBox<>(FXCollections.observableArrayList(existingCourseIds));
        txtParentCourseId.setLabelFloat(true);
        txtParentCourseId.setPromptText("Course Id");

        btnOk = new JFXButton("OK");
        btnOk.setOnAction(e -> controller.add());

        error = new Label();
        error.setTextFill(Paint.valueOf("red"));

        bottomContainer = new HBox(btnOk);
        bottomContainer.setAlignment(Pos.BASELINE_RIGHT);
        container.getChildren().addAll(title, txtParentCourseId, nameInput, filePath,btnOk);
        container.setSpacing(20);
        pane.setCenter(container);
        pane.setBottom(bottomContainer);
        pane.setPrefHeight(300);
        pane.setPrefWidth(400);
        pane.setPadding(new Insets(30, 30, 30, 30));


        controller.nameInput = nameInput;
        controller.txtParentCourseId = txtParentCourseId;
        controller.filePath = this.filePath;
        controller.fileChooser = this.fileChooser;
        controller.error = error;
    }

    @Override
    protected Pane getContent() {
        return pane;
    }
}
