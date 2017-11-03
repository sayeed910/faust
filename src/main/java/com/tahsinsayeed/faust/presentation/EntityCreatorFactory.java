package com.tahsinsayeed.faust.presentation;

import com.google.inject.*;
import com.tahsinsayeed.faust.presentation.entitycreator.assignmentcreator.AssignmentCreator;
import com.tahsinsayeed.faust.presentation.entitycreator.bookcreator.BookCreator;
import com.tahsinsayeed.faust.presentation.entitycreator.classcreator.ClassCreator;
import com.tahsinsayeed.faust.presentation.entitycreator.coursecreator.CourseCreator;
import com.tahsinsayeed.faust.presentation.entitycreator.examcreator.ExamCreator;
import com.tahsinsayeed.faust.presentation.entitycreator.holidaycreator.HolidayCreator;
import com.tahsinsayeed.faust.presentation.entitycreator.notecreator.NoteCreator;
import com.tahsinsayeed.faust.presentation.view.EntityCreationDialog;

/**
 * Created by sayeed on 10/26/17.
 */
public class EntityCreatorFactory {
    @Inject
    Provider<CourseCreator> courseCreationViewProvider;
    @Inject
    Provider<AssignmentCreator> assignmentCreationViewProvider;
    @Inject
    Provider<ExamCreator> examCreationViewProvider;
    @Inject
    Provider<BookCreator> bookCreationViewProvider;
    @Inject
    Provider<ClassCreator> classCreationViewProvider;

    @Inject Provider<HolidayCreator> holidayCreationViewProvider;

    @Inject Provider<NoteCreator> noteCreationViewProvider;

    public EntityCreationDialog create(String entityName){
        if (entityName.equalsIgnoreCase("course")) return courseCreationViewProvider.get();
        else if (entityName.equalsIgnoreCase("assignment")) return assignmentCreationViewProvider.get();
        else if (entityName.equalsIgnoreCase("exam")) return examCreationViewProvider.get();
        else if (entityName.equalsIgnoreCase("book")) return bookCreationViewProvider.get();
        else if (entityName.equalsIgnoreCase("holiday")) return holidayCreationViewProvider.get();
        else if (entityName.equalsIgnoreCase("class")) return classCreationViewProvider.get();
        else if (entityName.equalsIgnoreCase("note")) return noteCreationViewProvider.get();
        else throw new IllegalArgumentException();

    }
}
