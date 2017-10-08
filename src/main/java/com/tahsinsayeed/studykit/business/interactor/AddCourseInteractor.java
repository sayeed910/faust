package com.tahsinsayeed.studykit.business.interactor;

import com.tahsinsayeed.studykit.business.entity.Course;
import com.tahsinsayeed.studykit.persistence.repository.*;

public class AddCourseInteractor implements Interactor {
    private String id;
    private String name;
    private RepositoryFactory repositoryFactory;

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
    }

}
