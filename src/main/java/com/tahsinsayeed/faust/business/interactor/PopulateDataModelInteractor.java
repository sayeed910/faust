package com.tahsinsayeed.faust.business.interactor;

import com.google.inject.Inject;
import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.business.entity.Course;
import com.tahsinsayeed.faust.presentation.controller.Interactor;

import java.time.LocalDate;
import java.util.List;

public class PopulateDataModelInteractor implements Interactor {


    private final Repository<Course> courseRepository;
    @Inject
    public PopulateDataModelInteractor(Repository<Course> courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public void execute(Request request) {
        List<Course> courses = courseRepository.getAll();

        if (courses == null) return;

        courses.forEach(course -> DtoBank.getInstance().addCourse(new CourseDto(course)));

        UpcomingTaskRetriever.create(LocalDate.now()).execute(null);
    }
}
