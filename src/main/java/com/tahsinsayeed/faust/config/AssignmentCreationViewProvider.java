package com.tahsinsayeed.faust.config;

import com.google.inject.*;
import com.tahsinsayeed.faust.presentation.entitycreator.assignmentcreator.*;
import com.tahsinsayeed.faust.presentation.model.ViewModelStorage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sayeed on 10/27/17.
 */
public class AssignmentCreationViewProvider implements Provider<AssignmentCreator> {
    @Inject
    AssignmentCreationController controller;
    @Override
    public AssignmentCreator get() {
        return new AssignmentCreator(getExistingCourseIds(), controller);
    }

    private List<String> getExistingCourseIds(){
        return ViewModelStorage.getInstance().getCourses().stream()
                .map(courseViewModel -> courseViewModel.getId().get()).collect(Collectors.toList());
    }
}
