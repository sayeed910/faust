package com.tahsinsayeed.faust.presentation.entitycreator.coursecreator;

import com.google.inject.Inject;
import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.business.interactor.*;
import com.tahsinsayeed.faust.presentation.controller.*;
import com.tahsinsayeed.faust.util.ContentValues;
import javafx.scene.control.Label;


public class CourseCreationController implements EntityCreationController {

    private final RequestBuilder requestBuilder;
    private InteractorFactory interactorFactory;
    Label error;
    JFXTextField idInput;
    JFXTextField nameInput;
    JFXDialog dialog;

    @Inject
    public CourseCreationController(RequestBuilder requestBuilder, InteractorFactory factory){
        this.requestBuilder = requestBuilder;
        this.interactorFactory = factory;
    }


    @Override
    public void add() {
        Interactor courseCreator = interactorFactory.make(InteractorFactory.InteractorType.ADD_COURSE);

        ContentValues args = getRequestArgs();

        Request newCourseRequest = requestBuilder.make(RequestBuilder.RequestType.NEW_COURSE, args);
        try {
            courseCreator.execute(newCourseRequest);
            dialog.close();
        } catch(CourseConflict ex){
            error.setText("Course with same id exists");
        }

    }

    private ContentValues getRequestArgs() {
        String courseId = idInput.getText().trim();
        String courseName = nameInput.getText().trim();

        System.out.println(courseId);
        System.out.println(courseName);

        return new ContentValues(
                "courseId", courseId,
                "courseName", courseName);
    }

    @Override
    public void cancel() {

    }
}
