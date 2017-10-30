package com.tahsinsayeed.faust.business.interactor;

import com.google.inject.Inject;
import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.request.NewClassRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;

import java.time.LocalDate;

public class AddClassInteractor implements Interactor {

    private final Repository<Class> classRepository;
    private final Repository<Course> courseRepository;

    @Inject
    public AddClassInteractor(Repository<Class> classRepository, Repository<Course> courseRepository) {
        this.classRepository = classRepository;
        this.courseRepository = courseRepository;

    }

    @Override
    public void execute(Request request) {
        NewClassRequest classRequest = (NewClassRequest) request;

        Course parentCourse = courseRepository.get(classRequest.parentCourseId);
        if (parentCourse == null) throw new CourseNotFound();

        Class clazz = Class.create(classRequest.parentCourseId, classRequest.classDay, classRequest.classTime);
        classRepository.save(clazz);


        UpcomingTaskRetriever.create(LocalDate.now()).execute(null);

    }

}
