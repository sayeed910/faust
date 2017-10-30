package com.tahsinsayeed.faust.business.interactor;

import com.google.inject.Inject;
import com.tahsinsayeed.faust.business.dto.AssignmentDto;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.request.NewAssignmentRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;
import com.tahsinsayeed.faust.presentation.model.DtoBank;

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

        Course parentCourse = courseRepository.get(assignmentRequest.parentCourseId);
        if (parentCourse == null) throw new CourseNotFound();

        Assignment assignment = Assignment.withRandomId(assignmentRequest.parentCourseId,
                        assignmentRequest.title, assignmentRequest.description,
                        assignmentRequest.dateOfSubmission);

        assignmentRepository.save(assignment);
        AssignmentDto assignmentDto = AssignmentDto.from(assignment);
        DtoBank.getInstance().addAssignment(assignmentDto);

        UpcomingTaskRetriever.create(LocalDate.now()).execute(null);

    }

}
