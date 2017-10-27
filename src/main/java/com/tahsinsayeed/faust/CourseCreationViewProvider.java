package com.tahsinsayeed.faust;

import com.google.inject.*;
import com.tahsinsayeed.faust.presentation.entitycreator.coursecreator.*;

/**
 * Created by sayeed on 10/27/17.
 */
public class CourseCreationViewProvider implements Provider<CourseCreator> {

    @Inject
    CourseCreationController controller;

    @Override
    public CourseCreator get() {
        return new CourseCreator(controller);
    }
}
