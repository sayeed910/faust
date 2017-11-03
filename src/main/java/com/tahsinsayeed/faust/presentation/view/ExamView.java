package com.tahsinsayeed.faust.presentation.view;

import com.google.common.eventbus.EventBus;
import com.tahsinsayeed.faust.presentation.model.ExamViewModel;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;

/**
 * Created by IMON on 10/29/17.
 */
public class ExamView extends VBox {

    private ExamViewModel examViewModel;
    private final EventBus mainEventBus;



    public ExamView(ExamViewModel examViewModel, EventBus mainEventBus) {
        this.examViewModel = examViewModel;
        this.mainEventBus = mainEventBus;

        setSpacing(10);
        setPadding(new Insets(30, 10, 10, 40));

        Text courseId = new Text("Course: " + examViewModel.getParentCourseId().get());
        courseId.setFont(Font.font(18));

        Text examTitle = new Text(examViewModel.getName().get());
        examTitle.setFont(Font.font(24));
        Text examDate = new Text("Date: " + examViewModel.getExamDate());
        examDate.setFont(Font.font(14));
        Text examTime = new Text("Time: " + examViewModel.getExamTime());
        examTime.setFont(Font.font(14));
        getChildren().addAll(examTitle, courseId, examDate, examTime);

//        getChildren().add(new Text("Total Marks " + examViewModel.getTotalMark()));
//        getChildren().add(new Text("Received Marks: " + examViewModel.getReceivedMark()));


        setMaxSize(500, 300);
        setBackground(new Background(new BackgroundFill(Paint.valueOf("white"), null, null)));
    }


}
