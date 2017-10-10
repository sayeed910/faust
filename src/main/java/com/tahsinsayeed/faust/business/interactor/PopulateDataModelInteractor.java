package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.business.entity.Course;
import com.tahsinsayeed.faust.persistence.memory.repository.*;

import java.util.List;

public class PopulateDataModelInteractor implements Interactor {
    DtoBank dtoBank = DtoBank.getInstance();
    private final RepositoryFactory factory = new RepositoryFactoryImpl();

    @Override
    public void execute() {
        Repository<Course> courseRepository = factory.getCourseRepository();
        List<Course> courses = courseRepository.getAll();

        if (courses == null) throw new RuntimeException("Not init");

        courses.forEach(course -> {
            dtoBank.addCourse(new CourseDto(course));
        });
    }
}
