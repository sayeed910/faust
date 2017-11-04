package com.tahsinsayeed.faust.presentation.view;

import com.tahsinsayeed.faust.presentation.model.ClassViewModel;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;

import java.time.DayOfWeek;
import java.time.format.*;
import java.util.*;

/**
 * Created by sayeed on 11/4/17.
 */
public class RoutineView extends VBox{
    List<ClassViewModel> classes;
    List<Tab> tabs = new ArrayList<>();
    public RoutineView(List<ClassViewModel> classes) {
        this.classes = classes;
        TabPane tabPane = new TabPane();
        tabPane.setSide(Side.LEFT);

        for (int i = DayOfWeek.MONDAY.getValue(); i <= DayOfWeek.SUNDAY.getValue()  ; i++) {
            tabs.add(getTab(i));
        }

        tabPane.getTabs().addAll(tabs);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);


        getChildren().add(tabPane);
        setMaxSize(700, 600);
        setBackground(new Background(new BackgroundFill(Paint.valueOf("white"), null, null)));
    }

    private Tab getTab(int i) {
        VBox container = new VBox();
        container.setSpacing(20);
        String dayName = DayOfWeek.of(i).getDisplayName(TextStyle.FULL, Locale.US);
        Text title = new Text(dayName);
        title.setFont(Font.font(20));
        HBox titleBar = new HBox(title);
        titleBar.setAlignment(Pos.CENTER);
        container.getChildren().add(titleBar);

        int idx = 1;
        for (ClassViewModel clazz : classes) {

            if (clazz.getClassDay().getValue() == i){
                Label text = new Label(idx++ + ". " + "Course: " + clazz.getParentCourseId() + " At: " + clazz.getClassTime().format(DateTimeFormatter.ISO_TIME));
                text.setPadding(new Insets(0, 10, 0, 20));
                container.getChildren().add(text);
            }
        }


        return new Tab(dayName, container);
    }
}
