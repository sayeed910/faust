package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.request.NewExamRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;

import java.time.*;

public class AddExamInteractor implements Interactor {
    Repository<Course> courseRepository;
    Repository<Exam> examRepository;


    public AddExamInteractor(Repository<Course> courseRepository, Repository<Exam> examRepository) {

        this.courseRepository = courseRepository;
        this.examRepository = examRepository;
    }

    @Override
    public void execute(Request request) {

        NewExamRequest examRequest = (NewExamRequest) request;

        Course parentCourse = courseRepository.get(examRequest.parentCourseId);
        if (parentCourse == null) throw new CourseNotFound();


        Exam exam = Exam.create(examRequest.title, examRequest.parentCourseId,
                examRequest.examDate, examRequest.examTime);
        examRepository.save(exam);

        ExamDto examDto = new ExamDto(exam, parentCourse.getName());
        DtoBank.getInstance().addExam(examDto);

        UpcomingTaskRetriever.create(LocalDate.now()).execute(null);
    }

}
