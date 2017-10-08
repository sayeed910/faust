package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.Course;
import com.tahsinsayeed.faust.persistence.repository.*;

public class AddCourseInteractor implements Interactor<Void> {
    private String id;
    private String name;
    private RepositoryFactory repositoryFactory;

    public AddCourseInteractor(String id, String name) {
        this.id = id;
        this.name = name;
        this.repositoryFactory = new RepositoryFactoryImpl();
    }

    @Override
    public Void execute() {
        Repository<Course> courseRepository = repositoryFactory.getCourseRepository();
        Course course = Course.create(id, name);
        courseRepository.save(course);
        return null;
    }

}
