package com.tahsinsayeed.faust.presentation.event;

import com.tahsinsayeed.faust.presentation.model.AssignmentViewModel;

/**
 * Created by sayeed on 11/4/17.
 */
public class RemoveAssignmentEvent {
    private final AssignmentViewModel assignmentViewModel;

    public RemoveAssignmentEvent(AssignmentViewModel assignmentViewModel) {
        this.assignmentViewModel = assignmentViewModel;
    }
}
