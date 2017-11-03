package com.tahsinsayeed.faust.config;

import com.google.inject.*;
import com.tahsinsayeed.faust.presentation.entitycreator.bookcreator.*;
import com.tahsinsayeed.faust.presentation.model.ViewModelStorage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sayeed on 10/31/17.
 */
public class BookCreationViewProvider implements Provider<BookCreator> {
    @Inject
    BookCreationController controller;

    @Override
    public BookCreator get() {
        return new BookCreator(getExistingCourseIds(), controller);
    }

    private List<String> getExistingCourseIds(){
        return ViewModelStorage.getInstance().getCourses().stream()
                .map(courseViewModel -> courseViewModel.getId().get()).collect(Collectors.toList());
    }
}
