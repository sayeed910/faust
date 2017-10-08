package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.Course;
import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.persistence.repository.*;

import java.time.*;

public class AddClassInteractor implements Interactor<Void> {
    private String courseId;
    private DayOfWeek day;
    private LocalTime startTime;
    private RepositoryFactory repositoryFactory;

    public AddClassInteractor(String courseId, DayOfWeek day, LocalTime startTime) {
        this.courseId = courseId;
        this.day = day;
        this.startTime = startTime;
        this.repositoryFactory = new RepositoryFactoryImpl();
    }

    @Override
    public Void execute() {
        Repository<Class> classRepository = repositoryFactory.getClassRepository();
        Class clazz = Class.create(courseId, day, startTime);
        classRepository.save(clazz);
        return null;
    }

}
