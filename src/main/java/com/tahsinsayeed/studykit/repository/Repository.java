package com.tahsinsayeed.studykit.repository;

import java.util.List;

public interface Repository<T> {
    T get(String id);
    List<T> getAll();
    void save(T objectToSave);
    void update(T objectToUpdate);
    void delete(T objectToDelete);

    static Repository get(RepositoryType type){
        switch (type){
            case EXAM: return new ExamRepository();
            case HOLIDAY: return new HolidayRepository();
            case SCHEDULE: return new ScheduleRepository();
            case ASSIGNMENT: return new AssignmentRepository();
            case ATTENDANCE: return new AttendanceRepository();
            case CLASS: return new ClassRepository();
            case COURSE: return new CourseRepository();
            case SEMESTER: return new SemesterRepository();
            case EVENT: return new EventRepository();
            default: throw new IllegalArgumentException("Wrong type for repository");
        }
    }
}
