package com.tahsinsayeed.faust;

import com.google.inject.Inject;
import com.tahsinsayeed.faust.business.entity.Course;
import com.tahsinsayeed.faust.business.interactor.*;
import com.tahsinsayeed.faust.presentation.controller.*;

/**
 * Created by sayeed on 10/25/17.
 */
public class InteractorFactoryImpl implements InteractorFactory {

    private final RepositoryFactory repositoryFactory;

    @Inject
    public InteractorFactoryImpl(RepositoryFactory repositoryFactory) {
        this.repositoryFactory = repositoryFactory;
    }

    @Override
    public Interactor make(InteractorType type) {
        Repository<Course> courseRepository = repositoryFactory.getCourseRepository();
        switch(type){
            case ADD_ASSIGNMENT:
                return new AddAssignmentInteractor(
                        courseRepository, repositoryFactory.getAssignmentRepository());
            case ADD_BOOK:
                return new AddBookInteractor(
                        repositoryFactory.getBookRepository(), courseRepository);
            case ADD_CLASS:
                return new AddClassInteractor(
                        repositoryFactory.getClassRepository(), courseRepository);
            case ADD_COURSE:
                return new AddCourseInteractor(courseRepository);
            case ADD_EXAM:
                return new AddExamInteractor(courseRepository, repositoryFactory.getExamRepository());
            default:
                throw new IllegalArgumentException("Invalid type of interactor");
        }
    }
}
