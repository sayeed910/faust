package com.tahsinsayeed.faust.business.interactor;

import com.google.common.annotations.VisibleForTesting;
import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.persistence.repository.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class UpcomingTaskRetriever implements Interactor<UpcomingTask>{
    private final LocalDate date;
    private final RepositoryFactory repositoryFactory;
    private final Repository<Course> courseRepository;

    private UpcomingTaskRetriever(LocalDate date, RepositoryFactory factory) {
        this.repositoryFactory = factory;
        this.date = date;
        this.courseRepository = factory.getCourseRepository();

    }

    public static UpcomingTaskRetriever create(LocalDate date) {
        return new UpcomingTaskRetriever(date, new RepositoryFactoryImpl());
    }

    @VisibleForTesting
    static UpcomingTaskRetriever create(LocalDate date, RepositoryFactory factory){
        return new UpcomingTaskRetriever(date, factory);
    }

    private List<ClassDto> getTodaysClasses() {
        List<Class> classes = repositoryFactory.getClassRepository().getAll();
        return classes.stream()
                .filter((clazz)-> clazz.getDay().equals(date.getDayOfWeek()))
                .map(aClass -> new ClassDto(aClass, courseRepository.get(aClass.getCourseId()).getName()))
                .collect(Collectors.toList());

    }


    private List<ExamDto> getTodaysExams() {
        List<Exam> exams = repositoryFactory.getExamRepository().getAll();
        return exams.stream()
                .filter((exam)-> exam.getDate().equals(date))
                .map(exam -> new ExamDto(exam, courseRepository.get(exam.getCourseId()).getName()))
                .collect(Collectors.toList());
    }

    private List<AssignmentDto> getTodaysAssignments() {
        List<Assignment> assignments = repositoryFactory.getAssignmentRepository().getAll();
        return assignments.stream()
                .filter((assignment)-> assignment.getDate().equals(date))
                 .map(assignment ->
                         new AssignmentDto(assignment, courseRepository.get(assignment.getParentCourseId()).getName()))
                .collect(Collectors.toList());
    }

    @Override
    public UpcomingTask execute() {
        return new UpcomingTask(getTodaysClasses(), getTodaysAssignments(), getTodaysExams());
    }


}
