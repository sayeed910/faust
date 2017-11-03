package com.tahsinsayeed.faust.presentation.view;

import com.google.common.eventbus.EventBus;
import com.tahsinsayeed.faust.presentation.model.CourseViewModel;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;

/**
 * Created by IMON on 10/29/17.
 */
public class CourseView extends VBox {

    private CourseViewModel courseViewModel;
    private final EventBus mainEventBus;
    private BorderPane idBar;



    public CourseView(CourseViewModel courseViewModel, EventBus mainEventBus) {
        this.courseViewModel = courseViewModel;
        this.mainEventBus = mainEventBus;

        idBar = new BorderPane();
        Text id = new Text("Course Id -"+(courseViewModel.getId().get()));
        id.setFont(Font.font(20));
        idBar.setCenter(id);
        Insets topInsets;
        topInsets= new Insets(30,10,10,40);
        this.setPadding(topInsets);
        setBackground(new Background(new BackgroundFill(Paint.valueOf("white"), null, null)));
        setSpacing(10);
        getChildren().add(id);
        Text courseName = new Text("Course Name: " + courseViewModel.getName().get());
        setMargin(courseName,new Insets(0,0,15,0));
        courseName.setFont(Font.font(20));
        getChildren().add(courseName);
        Text bookCount = new Text("Total Books: " + courseViewModel.getBooks().size());
        bookCount.setFont(Font.font(16));
        getChildren().add(bookCount);
        Text examCount= new Text("Total Exams: " + courseViewModel.getExams().size());
        examCount.setFont(Font.font(16));
        getChildren().add(examCount);
        Text noteCount = new Text("Total Notes: " + courseViewModel.getNotes().size());
        noteCount.setFont(Font.font(16));
        getChildren().add(noteCount);
        Text assignmentCount = new Text("Total Assignments: " + courseViewModel.getAssignments().size());
        assignmentCount.setFont(Font.font(16));
        getChildren().add(assignmentCount);
        setMaxSize(500, 300);
    }


}
