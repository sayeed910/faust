package com.tahsinsayeed.faust.persistence.repository;

import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.entity.Class;

public interface RepositoryFactory {
    Repository<Event> getEventRepository();

    Repository<Semester> getSemesterRepository();

    Repository<Course> getCourseRepository();

    Repository<Class> getClassRepository();

    Repository<Attendance> getAttendanceRepository();

    Repository<Assignment> getAssignmentRepository();

    Repository<Schedule> getScheduleRepository();

    Repository<Holiday> getHolidayRepository();

    Repository<Exam> getExamRepository();

    Repository<Book> getBookRepository();
}
