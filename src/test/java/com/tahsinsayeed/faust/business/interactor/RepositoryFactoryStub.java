package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.entity.Class;

public class RepositoryFactoryStub implements RepositoryFactory {

    public Repository<Class> classRepository  = null;
    public Repository<Assignment> assignmentRepository = null;
    public Repository<Exam> examRepository = null;


    @Override
    public Repository<Course> getCourseRepository() {
        return null;
    }

    @Override
    public Repository<Class> getClassRepository() {
        return classRepository;
    }



    @Override
    public Repository<Assignment> getAssignmentRepository() {
        return assignmentRepository;
    }



    @Override
    public Repository<Holiday> getHolidayRepository() {
        return null;
    }

    @Override
    public Repository<Exam> getExamRepository() {
        return examRepository;
    }

    @Override
    public Repository<Book> getBookRepository() {
        return null;
    }

    @Override
    public Repository<Note> getNoteRepository() {
        return null;
    }
}
