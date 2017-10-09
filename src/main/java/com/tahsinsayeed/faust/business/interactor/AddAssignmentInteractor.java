package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.persistence.memory.repository.*;

import java.time.LocalDate;

public class AddAssignmentInteractor implements Interactor {
    private String title;
    private String description;
    private String parentCourseId;
    private LocalDate dueDate;
    private RepositoryFactory repositoryFactory;
    private final DtoBank dtoBank = DtoBank.getInstance();

    public AddAssignmentInteractor(String parentCourseId, String title, LocalDate dueDate, String description) {
        this.parentCourseId = parentCourseId;
        this.dueDate = dueDate;
        this.title = this.title;
        this.description = this.description;
        this.repositoryFactory = new RepositoryFactoryImpl();
    }

    @Override
    public void execute() {
        Repository<Assignment> assignmentRepository = repositoryFactory.getAssignmentRepository();
        Assignment assignment = Assignment.createWithDescription(parentCourseId, title, description, dueDate);
        assignmentRepository.save(assignment);
        AssignmentDto assignmentDto = new AssignmentDto(assignment,
                repositoryFactory.getCourseRepository().get(assignment.getParentCourseId()));
        dtoBank.addAssignment(assignmentDto);
        UpcomingTaskRetriever.create(LocalDate.now()).execute();

    }

}
