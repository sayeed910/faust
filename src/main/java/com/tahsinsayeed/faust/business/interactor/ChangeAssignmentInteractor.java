package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.Assignment;
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

    }
}
