package com.tahsinsayeed.faust.config;

import com.google.inject.*;
import com.tahsinsayeed.faust.presentation.entitycreator.notecreator.*;
import com.tahsinsayeed.faust.presentation.model.DtoBank;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sayeed on 10/31/17.
 */
public class NoteCreationViewProvider implements Provider<NoteCreator> {

    @Inject
    NoteCreationController controller;
    @Override
    public NoteCreator get() {
        return new NoteCreator(getExistingCourseIds(), controller);
    }

    private List<String> getExistingCourseIds(){
        return DtoBank.getInstance().getCourses().stream()
                .map(courseViewModel -> courseViewModel.getId().get()).collect(Collectors.toList());
    }
}
