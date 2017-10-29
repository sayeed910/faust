package com.tahsinsayeed.faust.presentation.event;

/**
 * Created by sayeed on 10/29/17.
 */
public class AssignmentFinishedPropertyChangedEvent {
    public final String id;
    public final boolean finished;

    public AssignmentFinishedPropertyChangedEvent(String id, boolean finished) {
        this.id = id;
        this.finished = finished;
    }
}
