package com.tahsinsayeed.faust.business.interactor;

import com.google.common.annotations.VisibleForTesting;
import com.tahsinsayeed.faust.business.dto.UpcomingTask;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.persistence.repository.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class UpcomingTaskRetriever implements Interactor<UpcomingTask>{
    private final LocalDate date;
    private final RepositoryFactory repositoryFactory;

    private UpcomingTaskRetriever(LocalDate date, RepositoryFactory factory) {
        this.repositoryFactory = factory;
        this.date = date;

    }

    public static UpcomingTaskRetriever create(LocalDate date) {
        return new UpcomingTaskRetriever(date, new RepositoryFactoryImpl());
    }

    @VisibleForTesting
    static UpcomingTaskRetriever create(LocalDate date, RepositoryFactory factory){
        return new UpcomingTaskRetriever(date, factory);
    }

    public List<Class> getClassesOn(LocalDate date) {
        List<Class> classes = repositoryFactory.getClassRepository().getAll();
        return classes.stream()
                .filter((clazz)-> clazz.getDay().equals(date.getDayOfWeek()))
                .collect(Collectors.toList());

    }


    public List<Exam> getExamsOn(LocalDate date) {
        List<Exam> exams = repositoryFactory.getExamRepository().getAll();
        return exams.stream()
                .filter((exam)-> exam.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<Assignment> getAssignmentsOn(LocalDate date) {
        List<Assignment> assignments = repositoryFactory.getAssignmentRepository().getAll();
        return assignments.stream()
                .filter((exam)-> exam.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public UpcomingTask execute() {

        return null;
    }


}
