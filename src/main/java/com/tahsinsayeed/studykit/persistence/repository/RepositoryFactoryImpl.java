package com.tahsinsayeed.studykit.persistence.repository;

import com.tahsinsayeed.studykit.business.entity.*;
import com.tahsinsayeed.studykit.business.entity.Class;

public class RepositoryFactoryImpl implements RepositoryFactory {

    @Override
    public Repository<Event> getEventRepository() {
        return new EventRepository();
    }

    @Override
    public Repository<Semester> getSemesterRepository() {
        return new SemesterRepository();
    }

    @Override
    public Repository<Course> getCourseRepository() {
        return new CourseRepository();
    }

    @Override
    public Repository<Class> getClassRepository() {
        return new ClassRepository();
    }

    @Override
    public Repository<Attendance> getAttendanceRepository() {
        return new AttendanceRepository();
    }

    @Override
    public Repository<Assignment> getAssignmentRepository() {
        return new AssignmentRepository();
    }

    @Override
    public Repository<Schedule> getScheduleRepository() {
        return new ScheduleRepository();
    }

    @Override
    public Repository<Holiday> getHolidayRepository() {
        return new HolidayRepository();
    }

    @Override
    public Repository<Exam> getExamRepository() {
        return new ExamRepository();
    }
}
