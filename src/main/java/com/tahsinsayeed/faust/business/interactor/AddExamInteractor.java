package com.tahsinsayeed.faust.business.interactor;

import com.google.inject.Inject;
import com.tahsinsayeed.faust.business.dto.ExamDto;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.request.NewExamRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;
import com.tahsinsayeed.faust.presentation.model.ViewModelStorage;

import java.time.LocalDate;

public class AddExamInteractor implements Interactor {
    Repository<Course> courseRepository;
    Repository<Exam> examRepository;


    @Inject
    public AddExamInteractor(Repository<Course> courseRepository, Repository<Exam> examRepository) {

        this.courseRepository = courseRepository;
        this.examRepository = examRepository;
    }

    @Override
    public void execute(Request request) {

        NewExamRequest examRequest = (NewExamRequest) request;

        System.out.println(examRequest.parentCourseId);
        if (!courseRepository.idExists(examRequest.parentCourseId)) throw new CourseNotFound();


        Exam exam = Exam.create(examRequest.title, examRequest.parentCourseId,
                examRequest.examDate, examRequest.examTime);
        examRepository.save(exam);

        ExamDto examDto = ExamDto.from(exam);
        ViewModelStorage.getInstance().add(examDto);

        UpcomingTaskRetriever.create(LocalDate.now()).execute(null);
    }

}
