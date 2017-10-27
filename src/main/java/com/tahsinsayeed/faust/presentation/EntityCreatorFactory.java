package com.tahsinsayeed.faust.presentation;

import com.google.inject.*;
import com.tahsinsayeed.faust.presentation.entitycreator.assignmentcreator.AssignmentCreator;
import com.tahsinsayeed.faust.presentation.entitycreator.coursecreator.CourseCreator;
import com.tahsinsayeed.faust.presentation.entitycreator.examcreator.ExamCreator;
import com.tahsinsayeed.faust.presentation.view.EntityCreationView;

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

    public EntityCreationView create(String entityName){
        if (entityName.equalsIgnoreCase("course")) return courseCreationViewProvider.get();
        else if (entityName.equalsIgnoreCase("assignment")) return assignmentCreationViewProvider.get();
        else if (entityName.equalsIgnoreCase("exam")) return examCreationViewProvider.get();
        else throw new IllegalArgumentException();

    }
}
