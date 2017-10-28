package com.tahsinsayeed.faust.config;

import com.google.inject.*;
import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.presentation.entitycreator.examcreator.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sayeed on 10/27/17.
 */
public class ExamCreationViewProvider implements Provider<ExamCreator> {
    @Inject
    ExamCreationController controller;
    @Override
    public ExamCreator get() {
        return new ExamCreator(getExistingCourseIds(), controller);
    }

    private List<String> getExistingCourseIds(){
        return DtoBank.getInstance().getCourses().stream()
                .map(CourseDto::getId).collect(Collectors.toList());
    }
}
