package com.tahsinsayeed.studykit.persistence.repository;

import com.tahsinsayeed.studykit.business.entity.*;
import com.tahsinsayeed.studykit.business.entity.Class;

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
}
