package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.persistence.memory.repository.*;

import java.time.LocalDate;

public class AddAssignmentInteractor implements Interactor<Void> {
    private String title;
    private String description;
    private String parentCourseId;
    private LocalDate dueDate;
    private RepositoryFactory repositoryFactory;

    public AddAssignmentInteractor(String parentCourseId, String title, LocalDate dueDate, String description) {
        this.parentCourseId = parentCourseId;
        this.dueDate = dueDate;
        this.title = this.title;
        this.description = this.description;
        this.repositoryFactory = new RepositoryFactoryImpl();
    }

    @Override
    public Void execute() {
        Repository<Assignment> assignmentRepository = repositoryFactory.getAssignmentRepository();
        Assignment assignment = Assignment.createWithDescription(parentCourseId, title, description, dueDate);
        assignmentRepository.save(assignment);
        return null;
    }

}
