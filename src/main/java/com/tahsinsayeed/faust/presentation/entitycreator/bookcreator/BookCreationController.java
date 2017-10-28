package com.tahsinsayeed.faust.presentation.entitycreator.bookcreator;

import com.google.inject.Inject;
import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.business.entity.Book;
import com.tahsinsayeed.faust.business.interactor.Request;
import com.tahsinsayeed.faust.presentation.controller.*;
import com.tahsinsayeed.faust.util.ContentValues;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

import java.time.format.DateTimeFormatter;

/**
 * Created by Shamim on 10/28/17.
 */
public class BookCreationController implements EntityCreationController {
    JFXComboBox<String> txtParentCourseId ;
    private final RequestBuilder requestBuilder;
    private InteractorFactory interactorFactory;
    Label error;
    JFXTextField nameInput;
    FileChooser fileChooser;
    JFXTextField filePath;


    @Inject
    public BookCreationController(RequestBuilder requestBuilder, InteractorFactory factory){
        this.requestBuilder = requestBuilder;
        this.interactorFactory = factory;
    }

    @Override
    public void add() {
        ContentValues values = getRequestArgs();
        Interactor bookCreator = interactorFactory.make(InteractorFactory.InteractorType.ADD_BOOK);
        Request newExamRequest = requestBuilder.make(RequestBuilder.RequestType.NEW_BOOK, values);

        bookCreator.execute(newExamRequest);

    }



    private ContentValues getRequestArgs() {
        String parentCourseId = txtParentCourseId.getSelectionModel().getSelectedItem();
        String bookName = nameInput.getText().trim();
        String fileName =  filePath.getText().trim();


        return new ContentValues(
                "courseId", parentCourseId,
                "bookName", bookName,
                "filePath", fileName
        );

    }

    @Override
    public void cancel() {

    }
}
