package com.tahsinsayeed.faust.business.interactor;

import com.google.inject.Inject;
import com.tahsinsayeed.faust.business.entity.Course;

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
            case ADD_NOTE:
                return new AddNoteInteractor(repositoryFactory.getNoteRepository(), courseRepository);
            case ADD_HOLIDAY:
                return new AddHolidayInteractor(repositoryFactory.getHolidayRepository());
            case EDIT_ASSIGNMENT:
                return new ChangeAssignmentInteractor(repositoryFactory.getAssignmentRepository());
            case EDIT_CLASS:
                return new ChangeClassInteractor(repositoryFactory.getClassRepository());
            case EDIT_COURSE:
                return new ChangeCourseInteractor(repositoryFactory.getCourseRepository());
            case EDIT_EXAM:
                return new ChangeExamInteractor(repositoryFactory.getExamRepository());
            case EDIT_HOLIDAY:
                return new ChangeHolidayInteractor(repositoryFactory.getHolidayRepository());
            case EDIT_NOTE:
                return new ChangeNoteInteractor(repositoryFactory.getNoteRepository());
            case REMOVE_ASSIGNMENT:
                return new RemoveAssignmentInteractor(repositoryFactory.getAssignmentRepository());
            case REMOVE_BOOK:
                return new RemoveBookInteractor(repositoryFactory.getBookRepository());
            case REMOVE_CLASS:
                return new RemoveClassInteractor(repositoryFactory.getClassRepository());
            case REMOVE_COURSE:
                return new RemoveCourseInteractor(repositoryFactory.getCourseRepository());
            case REMOVE_EXAM:
                return new RemoveExamInteractor(repositoryFactory.getExamRepository());
            case REMOVE_HOLIDAY:
                return new RemoveHolidayInteractor(repositoryFactory.getHolidayRepository());
            case REMOVE_NOTE:
                return new RemoveNoteInteractor(repositoryFactory.getNoteRepository());

            default:
                throw new IllegalArgumentException("Invalid type of interactor");
        }
    }
}
