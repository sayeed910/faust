package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.Assignment;
import com.tahsinsayeed.faust.business.request.RemoveAssignmentRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;

/**
 * Created by IMON on 11/3/2017.
 */
public class RemoveAssignmentInteractor implements Interactor {
    private final Repository<Assignment> assignmentRepository;

    public RemoveAssignmentInteractor(Repository<Assignment> assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public void execute(Request request) {
        RemoveAssignmentRequest assignmentRequest = (RemoveAssignmentRequest) request;

        Assignment assignment = assignmentRepository.get(assignmentRequest.id);
        assignmentRepository.delete(assignment);

    }
}