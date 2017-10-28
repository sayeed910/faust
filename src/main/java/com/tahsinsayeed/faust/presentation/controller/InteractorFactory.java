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
        ADD_COURSE, ADD_EXAM, ADD_ASSIGNMENT, ADD_CLASS, ADD_BOOK, ADD_HOLIDAY, ADD_NOTE
    }
}
