package com.tahsinsayeed.faust.persistence.repository;

import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.business.interactor.*;

/**
 *  Created by Shamim
 */
public class RepositoryFactoryImpl implements RepositoryFactory {




    @Override
    public Repository<Course> getCourseRepository() {
        return new CourseRepository();
    }

    @Override
    public Repository<Class> getClassRepository() {
        return new ClassRepository();
    }



    @Override
    public Repository<Assignment> getAssignmentRepository() {
        return new AssignmentRepository();
    }

    @Override
    public Repository<Holiday> getHolidayRepository() {
        return new HolidayRepository();
    }

    @Override
    public Repository<Exam> getExamRepository() {
        return new ExamRepository();
    }

    @Override
    public Repository<Book> getBookRepository() {
        return new BookRepository();
    }

    @Override
    public Repository<Note> getNoteRepository() {
        return new NoteRepository();
    }
}
