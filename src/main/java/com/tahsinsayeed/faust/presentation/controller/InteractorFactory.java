package com.tahsinsayeed.faust.presentation.controller;

/**
 * Created by sayeed on 10/25/17.
 */
public interface InteractorFactory {
    Interactor make(InteractorType type);

    /**
     * Created by sayeed on 10/25/17.
     */
    enum InteractorType {
        ADD_COURSE, ADD_EXAM, ADD_ASSIGNMENT, ADD_CLASS, ADD_BOOK, ADD_HOLIDAY, ADD_NOTE,
        EDIT_ASSIGNMENT, EDIT_CLASS, EDIT_COURSE, EDIT_EXAM, EDIT_HOLIDAY ,EDIT_NOTE,
        REMOVE_ASSIGNMENT, REMOVE_BOOK, REMOVE_CLASS, REMOVE_COURSE, REMOVE_EXAM, REMOVE_HOLIDAY, REMOVE_NOTE
    }
}
