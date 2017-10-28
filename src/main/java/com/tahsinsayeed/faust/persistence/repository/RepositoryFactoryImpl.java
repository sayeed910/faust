package com.tahsinsayeed.faust.persistence.repository;

import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.business.interactor.*;

public class RepositoryFactoryImpl implements RepositoryFactory {


    @Override
    public Repository<CourseDto, Course> getCourseRepository() {
        return new CourseRepository();
    }

    @Override
    public Repository<ClassDto, Class> getClassRepository() {
        return new ClassRepository();
    }



    @Override
    public Repository<AssignmentDto, Assignment> getAssignmentRepository() {
        return new AssignmentRepository();
    }



    @Override
    public Repository<HolidayDto, Holiday> getHolidayRepository() {
        return new HolidayRepository();
    }

    @Override
    public Repository<ExamDto, Exam> getExamRepository() {
        return new ExamRepository();
    }

    @Override
    public Repository<BookDto, Book> getBookRepository() {
        return new BookRepository();
    }
}
