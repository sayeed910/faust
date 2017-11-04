package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.Assignment;
import com.tahsinsayeed.faust.business.request.ChangeAssignmentRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;

/**
 * Created by IMON on 11/3/2017.
 */
public class ChangeAssignmentInteractor implements Interactor {
    private final Repository<Assignment> assignmentRepository;

    public ChangeAssignmentInteractor(Repository<Assignment> assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public void execute(Request request) {
        ChangeAssignmentRequest assignmentRequest = (ChangeAssignmentRequest) request;

        System.out.println(assignmentRequest.id);

        Assignment assignment = assignmentRepository.get(assignmentRequest.id);

        assignment.setDescription(assignmentRequest.description);
        assignment.setTitle(assignmentRequest.title);
        assignment.setFinished(assignmentRequest.finished);
        assignment.setDueDate(assignmentRequest.dueDate);

        assignmentRepository.update(assignment);

    }
}
