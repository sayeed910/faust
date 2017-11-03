package com.tahsinsayeed.faust.business.interactor;

import com.google.common.annotations.VisibleForTesting;
import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.persistence.repository.RepositoryFactoryImpl;
import com.tahsinsayeed.faust.presentation.controller.Interactor;
import com.tahsinsayeed.faust.presentation.model.ViewModelStorage;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class UpcomingTaskRetriever implements Interactor {
    private final LocalDate date;
    private final RepositoryFactory repositoryFactory;
    private final Repository<Course> courseRepository;
    private final ViewModelStorage dtoBank = ViewModelStorage.getInstance();

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
                .map(ClassDto::from)
                .collect(Collectors.toList());

    }


    private List<ExamDto> getTodaysExams() {
        List<Exam> exams = repositoryFactory.getExamRepository().getAll();
        return exams.stream()
                .filter((exam)-> exam.getDate().equals(date))
                .map(ExamDto::from)
                .collect(Collectors.toList());
    }

    private List<AssignmentDto> getTodaysAssignments() {
        List<Assignment> assignments = repositoryFactory.getAssignmentRepository().getAll();
        return assignments.stream()
                .filter((assignment)-> assignment.getDueDate().equals(date))
                 .map(AssignmentDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public void execute(Request request) {
//        dtoBank.setUpcomingTask(UpcomingTasks.from(getTodaysClasses(), getTodaysAssignments(), getTodaysExams()));
    }


}
