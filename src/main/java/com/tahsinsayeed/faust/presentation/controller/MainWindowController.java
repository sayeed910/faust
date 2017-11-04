package com.tahsinsayeed.faust.presentation.controller;

import com.google.common.eventbus.*;
import com.google.inject.Inject;
import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.business.interactor.Request;
import com.tahsinsayeed.faust.presentation.component.notebook.*;
import com.tahsinsayeed.faust.presentation.component.reader.*;
import com.tahsinsayeed.faust.presentation.entitycreator.EntityCreatorFactory;
import com.tahsinsayeed.faust.presentation.entityeditor.assignmenteditor.*;
import com.tahsinsayeed.faust.presentation.event.*;
import com.tahsinsayeed.faust.presentation.model.*;
import com.tahsinsayeed.faust.presentation.view.*;
import com.tahsinsayeed.faust.util.ContentValues;
import javafx.animation.Transition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;

import java.util.*;

public class MainWindowController {
    @FXML
    private StackPane root;

    @FXML
    private StackPane titleBurgerContainer;
    @FXML
    private JFXHamburger titleBurger;

    @FXML
    private StackPane optionsBurger;
    @FXML
    private JFXRippler optionsRippler;
    @FXML
    private JFXDrawer drawer;

    @FXML
    private StackPane content;

    @FXML StackPane fab;
//    StackPane fab = new StackPane();

    @Inject
    private EventBus mainEventBus;

    @Inject
    SideBarView sideBar;

    @Inject
    EntityCreatorFactory entityCreatorFactory;

    @Inject
    com.tahsinsayeed.faust.presentation.component.NewItem newItem;

    @Inject
    InteractorFactory interactorFactory;
    @Inject RequestBuilder requestBuilder;

    public void initialize() throws Exception {

        drawer.setOnDrawerOpening(e -> {
            final Transition animation = titleBurger.getAnimation();
            animation.setRate(1);
            animation.play();
        });
        drawer.setOnDrawerClosing(e -> {
            final Transition animation = titleBurger.getAnimation();
            animation.setRate(-1);
            animation.play();
        });
        titleBurgerContainer.setOnMouseClicked(e -> {
            if (drawer.isHidden() || drawer.isHiding()) {
                System.out.println("opening");
                drawer.open();
            } else {
                drawer.close();
            }
        });


        drawer.setSidePane(sideBar);

        fab.getChildren().add(newItem);
        onDashboardSelect(null);

        mainEventBus.register(this);

    }


    @Subscribe
    public void handleNewItemCall(NewItemEvent event){
        System.out.println("called " + event.itemName);
        EntityCreationDialog view = entityCreatorFactory.create(event.itemName);
        view.showDialog(root);
    }

    @Subscribe
    public void handleNewNoteCall(EditNoteEvent event){
        NoteViewModel noteViewModel = new NoteViewModel();
        noteViewModel.setId(event.id);
        noteViewModel.setParentCourseId(event.parentCourseId);
        noteViewModel.setTitle(event.title);
        noteViewModel.setContent("");

        NoteEditor editor = NoteEditorFactory.get(mainEventBus, noteViewModel);
        content.getChildren().clear();
        content.getChildren().add(editor);
        editor.loadContent();
    }

    @Subscribe
    public void handleSaveNoteEvent(SaveNoteEvent event){
        System.out.println("called");
        Interactor editNoteInteractor = interactorFactory.make(InteractorFactory.InteractorType.EDIT_NOTE);
        ContentValues values = new ContentValues("id", event.id, "title", event.title, "content", event.content);
        Request editNoteRequest = requestBuilder.make(RequestBuilder.RequestType.EDIT_NOTE, values);
        editNoteInteractor.execute(editNoteRequest);

        System.out.println("saved" + event.content);
    }

    @Subscribe
    public void onCalendarSelect(CalendarItemSelected event){

        ViewModelStorage viewModelStorage = ViewModelStorage.getInstance();
        ObservableList<CourseViewModel> courses = viewModelStorage.getCourses();
        List<ExamViewModel> exams = new ArrayList<>();
        List<AssignmentViewModel> assignments = new ArrayList<>();

        for (CourseViewModel model: courses){
            exams.addAll(model.getExams());
            assignments.addAll(model.getAssignments());
        }

        content.getChildren().clear();
        content.getChildren().add(new CalendarView(assignments, exams, viewModelStorage.getHolidays()));
    }

    @Subscribe
    public void onBookSelect(BookItemSelected event){

        BookViewModel book = event.bookViewModel;

        PdfViewer reader = PdfViewerFactory.get();
        content.getChildren().clear();
        content.getChildren().add(reader);
        reader.loadPdf(book.getFilePath().get());


    }

    @Subscribe
    public void onNoteSelect(NoteItemSelected event){

        NoteViewModel note = event.noteViewModel;

        NoteEditor editor = NoteEditorFactory.get(mainEventBus, note);
        content.getChildren().clear();
        content.getChildren().add(editor);
        String content = note.getContent().get();
        System.out.println(content);
        editor.load(content);

    }

    @Subscribe
    public void onCourseSelect(CourseItemSelected event){
        System.out.println("Course selected");
        CourseViewModel course = event.courseViewModel;
        content.getChildren().clear();
        CourseView courseView = new CourseView(course, mainEventBus);
        content.getChildren().add(courseView);
        content.setMargin(courseView, new Insets(60, 20, 20, 20));
    }

    @Subscribe
    public void onAssignmentSelect(AssignmentItemSelected event){
        System.out.println("Assignment selected");
        AssignmentViewModel assigment = event.assignmentViewModel;
        content.getChildren().clear();
        AssignmentView assignmentView = new AssignmentView(assigment, mainEventBus);
        content.getChildren().add(assignmentView);
        content.setMargin(assignmentView, new Insets(60, 20, 20, 20));
    }

    @Subscribe
    public void onRoutineSelect(RoutineItemSelected event){

        content.getChildren().clear();
        RoutineView routineView = new RoutineView(ViewModelStorage.getInstance().getClasses());
        content.getChildren().add(routineView);
        content.setMargin(routineView, new Insets(60, 20, 20, 20));
    }

    @Subscribe
    public void onExamSelect(ExamItemSelected event){
        System.out.println("Exam selected");
        ExamViewModel exam = event.examViewModel;
        content.getChildren().clear();
        ExamView examView = new ExamView(exam, mainEventBus);
        content.getChildren().add(examView);
        content.setMargin(examView, new Insets(60, 20, 20, 20));
    }

    @Subscribe
    public void onDashboardSelect(DashboardItemSelected event){
        content.getChildren().clear();
        UpcomingTaskView upcomingTaskView = new UpcomingTaskView(ViewModelStorage.getInstance().getUpcomingTask());
        content.getChildren().add(upcomingTaskView);

        content.setMargin(upcomingTaskView, new Insets(60, 20, 20, 20));
    }


    @Subscribe
    public void onAssignmentEdit(ChangeAssignmentEvent event){
        if (event.showDialog){
            new AssignmentEditor(event.viewModel, new AssignmentEditorController(requestBuilder, interactorFactory)).showDialog(root);
        } else{

            ContentValues values = new ContentValues(
                    "assignmentTitle", event.viewModel.getTitle().get(),
                    "dueDate", event.viewModel.getDueDate(),
                    "description", event.viewModel.getDescription().get(),
                    "id", event.viewModel.getId().get(),
                    "finished", Boolean.toString(event.viewModel.isFinished()));

            Request request = requestBuilder.make(RequestBuilder.RequestType.EDIT_ASSIGNMENT, values);
            Interactor interactor = interactorFactory.make(InteractorFactory.InteractorType.EDIT_ASSIGNMENT);
            interactor.execute(request);
        }
    }




}


