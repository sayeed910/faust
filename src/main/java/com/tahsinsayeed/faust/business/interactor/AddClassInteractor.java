package com.tahsinsayeed.faust.business.interactor;

import com.google.inject.Inject;
import com.tahsinsayeed.faust.business.dto.ClassDto;
import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.request.NewClassRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;
import com.tahsinsayeed.faust.presentation.model.ViewModelStorage;

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

        if (!courseRepository.idExists(classRequest.parentCourseId)) throw new CourseNotFound();

        Class clazz = Class.create(classRequest.parentCourseId, classRequest.classDay, classRequest.classTime);
        classRepository.save(clazz);

        ViewModelStorage.getInstance().add(ClassDto.from(clazz));


//        UpcomingTaskRetriever.create(LocalDate.now()).execute(null);

    }

}
