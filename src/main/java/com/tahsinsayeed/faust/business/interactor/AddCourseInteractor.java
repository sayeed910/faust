package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.business.entity.Course;
import com.tahsinsayeed.faust.persistence.memory.repository.*;

public class AddCourseInteractor implements Interactor {
    private String id;
    private String name;
    private RepositoryFactory repositoryFactory;
    private DtoBank dtoBank = DtoBank.getInstance();

    public AddCourseInteractor(String id, String name) {
        this.id = id;
        this.name = name;
        this.repositoryFactory = new RepositoryFactoryImpl();
    }

    @Override
    public void execute() {
        Repository<Course> courseRepository = repositoryFactory.getCourseRepository();
        Course course = Course.create(id, name);
        courseRepository.save(course);

        CourseDto courseDto = new CourseDto(course);
        dtoBank.addCourse(courseDto);
    }

}
