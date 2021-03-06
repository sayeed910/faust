package com.tahsinsayeed.faust.business.interactor;

import com.google.inject.Inject;
import com.tahsinsayeed.faust.business.dto.AssignmentDto;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.request.NewAssignmentRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;
import com.tahsinsayeed.faust.presentation.model.ViewModelStorage;

import java.time.LocalDate;

public class AddAssignmentInteractor implements Interactor {

    private final Repository<Course> courseRepository;
    private final Repository<Assignment> assignmentRepository;

    @Inject
    public AddAssignmentInteractor(Repository<Course> courseRepository, Repository<Assignment>assignmentRepository) {
        this.courseRepository = courseRepository;
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public void execute(Request request) {
        NewAssignmentRequest assignmentRequest = (NewAssignmentRequest) request;

        if (!courseRepository.idExists(assignmentRequest.parentCourseId)) throw new CourseNotFound();

        Assignment assignment = Assignment.withRandomId(assignmentRequest.parentCourseId,
                        assignmentRequest.title, assignmentRequest.description,
                        assignmentRequest.dateOfSubmission);

        assignmentRepository.save(assignment);
        AssignmentDto assignmentDto = AssignmentDto.from(assignment);
        ViewModelStorage.getInstance().add(assignmentDto);

        UpcomingTaskRetriever.create(LocalDate.now()).execute(null);

    }

}
