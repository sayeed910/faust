package com.tahsinsayeed.faust.business.interactor;

import com.google.common.annotations.VisibleForTesting;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.persistence.repository.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ReminderInteractor {
    private final LocalDate date;
    private final RepositoryFactory repositoryFactory;

    private ReminderInteractor(LocalDate date, RepositoryFactory factory) {
        this.repositoryFactory = factory;
        this.date = date;

    }

    public static ReminderInteractor create(LocalDate date) {
        return new ReminderInteractor(date, new RepositoryFactoryImpl());
    }

    @VisibleForTesting
    static ReminderInteractor create(LocalDate date, RepositoryFactory factory){
        return new ReminderInteractor(date, factory);
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
}
