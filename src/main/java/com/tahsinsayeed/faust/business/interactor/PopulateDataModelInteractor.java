package com.tahsinsayeed.faust.business.interactor;

import com.google.inject.Inject;
import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.presentation.controller.Interactor;
import com.tahsinsayeed.faust.presentation.model.ViewModelStorage;

import java.time.LocalDate;
import java.util.List;

public class PopulateDataModelInteractor implements Interactor {


    private final RepositoryFactory repositoryFactory;
    @Inject
    public PopulateDataModelInteractor(RepositoryFactory repositoryFactory){
        this.repositoryFactory = repositoryFactory;
    }

    @Override
    public void execute(Request request) {
        List<Course> courses = repositoryFactory.getCourseRepository().getAll();
        List<Holiday> holidays = repositoryFactory.getHolidayRepository().getAll();
        List<Class> classes = repositoryFactory.getClassRepository().getAll();


        if (courses == null) return;

        courses.forEach(course -> ViewModelStorage.getInstance().add(new CourseDto(course)));
        holidays.forEach(holiday -> ViewModelStorage.getInstance().add(HolidayDto.from(holiday)));
        classes.forEach(clazz -> ViewModelStorage.getInstance().add(ClassDto.from(clazz)));

        UpcomingTaskRetriever.create(LocalDate.now()).execute(null);
    }
}
