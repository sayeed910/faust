package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.persistence.memory.repository.*;

import java.time.*;

public class AddClassInteractor implements Interactor {
    private String courseId;
    private DayOfWeek day;
    private LocalTime startTime;
    private RepositoryFactory repositoryFactory;
    private DtoBank dtoBank = DtoBank.getInstance();

    public AddClassInteractor(String courseId, DayOfWeek day, LocalTime startTime) {
        this.courseId = courseId;
        this.day = day;
        this.startTime = startTime;
        this.repositoryFactory = new RepositoryFactoryImpl();
    }

    @Override
    public void execute() {
        Repository<Class> classRepository = repositoryFactory.getClassRepository();
        Class clazz = Class.create(courseId, day, startTime);
        classRepository.save(clazz);

        UpcomingTaskRetriever.create(LocalDate.now()).execute();

    }

}
