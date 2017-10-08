package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.persistence.repository.*;

import java.time.*;

public class AddExamInteractor implements Interactor<Void> {
    private final String courseId;
    private final String name;
    private final LocalDate examDate;
    private final LocalTime examTime;
    private RepositoryFactory repositoryFactory;

    public AddExamInteractor(String courseId, String examName, LocalDate examDate, LocalTime examTime) {
        this.courseId = courseId;
        this.name = examName;
        this.examDate = examDate;
        this.examTime = examTime;
        this.repositoryFactory = new RepositoryFactoryImpl();
    }

    @Override
    public Void execute() {
        Repository<Exam> examRepository = repositoryFactory.getExamRepository();
        Exam exam = Exam.create(name, courseId, examDate, examTime);
        examRepository.save(exam);
        return null;
    }

}
