package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.entity.Class;

public interface RepositoryFactory {

    Repository<CourseDto, Course> getCourseRepository();

    Repository<ClassDto, Class> getClassRepository();

    Repository<AssignmentDto, Assignment> getAssignmentRepository();


    Repository<HolidayDto, Holiday> getHolidayRepository();

    Repository<ExamDto, Exam> getExamRepository();

    Repository<BookDto, Book> getBookRepository();
}
