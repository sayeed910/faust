package com.tahsinsayeed.faust.presentation.view;

import com.google.common.eventbus.Subscribe;
import com.tahsinsayeed.faust.presentation.event.*;
import com.tahsinsayeed.faust.presentation.model.*;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;

import java.time.format.DateTimeFormatter;

/**
 * Created by sayeed on 11/4/17.
 */
public class UpcomingTaskView extends VBox {
    UpcomingTask upcomingTask;

    public UpcomingTaskView(UpcomingTask upcomingTask) {
        this.upcomingTask = upcomingTask;
        Bus.get().register(this);
        addNodes();

        setSpacing(20);
        setMaxSize(500, 900);
        setPadding(new Insets(30, 10, 10, 30));
        setBackground(new Background(new BackgroundFill(Paint.valueOf("white"), null, null)));

    }

    private void addNodes() {
        if (upcomingTask.getUpcomingClasses().size() > 0) {
            Text classTitle = new Text("Today's Classes");
            classTitle.setFont(Font.font(24));
            getChildren().add(classTitle);
            addClassNodes(upcomingTask.getUpcomingClasses());
        }

        if (upcomingTask.getUpcomingAssignments().size() > 0) {
            Text assignmentTitle = new Text("Today's Assignments");
            assignmentTitle.setFont(Font.font(24));
            getChildren().add(assignmentTitle);
            addAssignmentNodes(upcomingTask.getUpcomingAssignments());
        }

        if (upcomingTask.getUpcomingExams().size() > 0) {
            Text examTitle = new Text("Today's Exams");
            examTitle.setFont(Font.font(24));
            getChildren().add(examTitle);
            addExamNodes(upcomingTask.getUpcomingExams());
        }
    }

    private void addExamNodes(ObservableList<ExamViewModel> upcomingExams) {
        int i = 1;
        for(ExamViewModel exam: upcomingExams){
            Text classTitle = new Text(i++ + ". " + exam.getName().get() + " Course: " + exam.getParentCourseId().get()
            + " At: " + exam.getExamTime().format(DateTimeFormatter.ISO_LOCAL_TIME));
            getChildren().add(classTitle);
        }
    }

    private void addAssignmentNodes(ObservableList<AssignmentViewModel> upcomingAssignments) {
        int i = 1;
        for(AssignmentViewModel assignment: upcomingAssignments){
            Text classTitle = new Text(i++ + ". " + assignment.getTitle().get() + " Course: " + assignment.getParentCourseId().get());
            getChildren().add(classTitle);
        }
    }

    private void addClassNodes(ObservableList<ClassViewModel> upcomingClasses) {
        int i = 1;
        for(ClassViewModel clazz: upcomingClasses){
            Text classTitle = new Text(i++ + ". " + "Course: " + clazz.getParentCourseId() + " At: "
                    + clazz.getClassTime().format(DateTimeFormatter.ISO_LOCAL_TIME));
            getChildren().add(classTitle);
        }
    }

    @Subscribe
    public void updateUpcomingTask(TaskAddedEvent event){
        upcomingTask = ViewModelStorage.getInstance().getUpcomingTask();
        getChildren().clear();
        addNodes();
    }
}
