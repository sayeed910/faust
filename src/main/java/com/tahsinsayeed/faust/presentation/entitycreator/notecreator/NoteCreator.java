package com.tahsinsayeed.faust.presentation.entitycreator.notecreator;

        import com.jfoenix.controls.*;
        import com.jfoenix.validation.*;
        import com.tahsinsayeed.faust.presentation.view.EntityCreationDialog;
        import com.tahsinsayeed.faust.presentation.component.*;
        import javafx.collections.FXCollections;
        import javafx.geometry.*;
        import javafx.scene.control.*;
        import javafx.scene.layout.*;
        import javafx.scene.paint.Paint;
        import javafx.scene.text.Font;
        import java.util.List;

/**
 * Created by Shamim on 10/28/17.
 */

public class NoteCreator extends EntityCreationDialog{
    private final JFXComboBox<String> txtParentCourseId;
    VBox container = new VBox();
    BorderPane pane = new BorderPane();
    private final JFXTextField nameInput;
    private final HBox bottomContainer;
    private Button btnOk;
    private Label error;
    private final NoteCreationController controller;


    public NoteCreator(List<String> existingCourseIds, NoteCreationController controller){
        this.controller = controller;

        Label title = new Label("New Note");
        title.setFont(Font.font(20));
        title.setPadding(new Insets(10, 10, 30, 10));

        nameInput = FloatingTextField.withPromptText("Note Name");
        nameInput.setValidators(new RequiredFieldValidator());


        txtParentCourseId = new JFXComboBox<>(FXCollections.observableArrayList(existingCourseIds));
        txtParentCourseId.setLabelFloat(true);
        txtParentCourseId.setPromptText("Course Id");

        btnOk = new JFXButton("OK");
        btnOk.setOnAction(e -> controller.add());

        error = new Label();
        error.setTextFill(Paint.valueOf("red"));

        bottomContainer = new HBox(btnOk);
        bottomContainer.setAlignment(Pos.BASELINE_RIGHT);
        container.getChildren().addAll(title, txtParentCourseId, nameInput,btnOk);
        container.setSpacing(20);
        pane.setCenter(container);
        pane.setBottom(bottomContainer);
        pane.setPrefHeight(300);
        pane.setPrefWidth(400);
        pane.setPadding(new Insets(30, 30, 30, 30));


        controller.nameInput = nameInput;
        controller.txtParentCourseId = txtParentCourseId;
        controller.error = error;
    }

    @Override
    protected Pane getContent() {
        return pane;
    }
}
