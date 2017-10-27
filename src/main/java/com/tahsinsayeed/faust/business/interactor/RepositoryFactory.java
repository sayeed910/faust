package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.entity.Class;

public interface RepositoryFactory {

    Repository<Course> getCourseRepository();

    Repository<Class> getClassRepository();

    Repository<Assignment> getAssignmentRepository();

    Repository<Schedule> getScheduleRepository();

    Repository<Holiday> getHolidayRepository();

    Repository<Exam> getExamRepository();

    Repository<Book> getBookRepository();
}
