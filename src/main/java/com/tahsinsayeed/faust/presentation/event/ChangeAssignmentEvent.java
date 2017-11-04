package com.tahsinsayeed.faust.presentation.event;

import com.tahsinsayeed.faust.presentation.model.AssignmentViewModel;

/**
 * Created by sayeed on 11/4/17.
 */
public class ChangeAssignmentEvent {
    public final AssignmentViewModel viewModel;
    public final boolean showDialog;

    public ChangeAssignmentEvent(AssignmentViewModel viewModel, boolean showDialog) {
        this.viewModel = viewModel;
        this.showDialog = showDialog;
    }
}
