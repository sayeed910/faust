package com.tahsinsayeed.studykit.business.interactor;

import com.tahsinsayeed.studykit.business.entity.*;
import com.tahsinsayeed.studykit.business.entity.Class;
import com.tahsinsayeed.studykit.persistence.repository.*;

public class RepositoryFactoryStub implements RepositoryFactory {

    public Repository<Class> classRepository  = null;
    public Repository<Assignment> assignmentRepository = null;
    public Repository<Exam> examRepository = null;

    @Override
    public Repository<Event> getEventRepository() {
        return null;
    }

    @Override
    public Repository<Semester> getSemesterRepository() {
        return null;
    }

    @Override
    public Repository<Course> getCourseRepository() {
        return null;
    }

    @Override
    public Repository<Class> getClassRepository() {
        return classRepository;
    }

    @Override
    public Repository<Attendance> getAttendanceRepository() {
        return null;
    }

    @Override
    public Repository<Assignment> getAssignmentRepository() {
        return assignmentRepository;
    }

    @Override
    public Repository<Schedule> getScheduleRepository() {
        return null;
    }

    @Override
    public Repository<Holiday> getHolidayRepository() {
        return null;
    }

    @Override
    public Repository<Exam> getExamRepository() {
        return examRepository;
    }
}
