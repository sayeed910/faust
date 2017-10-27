package com.tahsinsayeed.faust.presentation;

import com.google.inject.Inject;
import com.tahsinsayeed.faust.presentation.entitycreator.assignmentcreator.AssignmentCreationView;
import com.tahsinsayeed.faust.presentation.entitycreator.coursecreator.CourseCreationView;
import com.tahsinsayeed.faust.presentation.entitycreator.examcreator.ExamCreationView;
import com.tahsinsayeed.faust.presentation.view.EntityCreationView;

/**
 * Created by sayeed on 10/26/17.
 */
public class EntityCreatorFactory {
    @Inject
    CourseCreationView courseCreationView;
    @Inject
    AssignmentCreationView assignmentCreationView;
    @Inject
    ExamCreationView examCreationView;

    public EntityCreationView create(String entityName){
        if (entityName.equalsIgnoreCase("course")) return courseCreationView;
        else if (entityName.equalsIgnoreCase("assignment")) return assignmentCreationView;
        else if (entityName.equalsIgnoreCase("exam")) return examCreationView;
        else throw new IllegalArgumentException();

    }
}
