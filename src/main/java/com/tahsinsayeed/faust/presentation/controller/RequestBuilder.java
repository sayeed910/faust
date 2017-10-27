package com.tahsinsayeed.faust.presentation.controller;

import com.tahsinsayeed.faust.business.interactor.Request;
import com.tahsinsayeed.faust.util.ContentValues;

import java.util.Map;

/**
 * Created by sayeed on 10/25/17.
 */
public interface RequestBuilder {
    Request make(RequestType type, ContentValues args);

    enum RequestType{NEW_COURSE, NEW_ASSIGNMENT, NEW_EXAM, NEW_BOOK, NEW_CLASS, NEW_NOTE }
}
