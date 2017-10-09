package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.persistence.memory.repository.*;

import java.time.*;

public class AddExamInteractor implements Interactor {
    private final String courseId;
    private final String name;
    private final LocalDate examDate;
    private final LocalTime examTime;
    private RepositoryFactory repositoryFactory;
    private DtoBank dtoBank = DtoBank.getInstance();

    public AddExamInteractor(String courseId, String examName, LocalDate examDate, LocalTime examTime) {
        this.courseId = courseId;
        this.name = examName;
        this.examDate = examDate;
        this.examTime = examTime;
        this.repositoryFactory = new RepositoryFactoryImpl();
    }

    @Override
    public void execute() {
        Repository<Exam> examRepository = repositoryFactory.getExamRepository();
        Exam exam = Exam.create(name, courseId, examDate, examTime);
        examRepository.save(exam);

        ExamDto examDto = new ExamDto(exam, repositoryFactory.getCourseRepository().get(exam.getCourseId()));
        dtoBank.addExam(examDto);

        UpcomingTaskRetriever.create(LocalDate.now()).execute();
    }

}
