package com.tahsinsayeed.faust.presentation.event;

import com.tahsinsayeed.faust.presentation.model.AssignmentViewModel;

/**
 * Created by sayeed on 11/3/17.
 */
public class AssignmentItemSelected {
    public final AssignmentViewModel assignmentViewModel;

    public AssignmentItemSelected(AssignmentViewModel assignmentViewModel) {
        this.assignmentViewModel = assignmentViewModel;
    }
}
