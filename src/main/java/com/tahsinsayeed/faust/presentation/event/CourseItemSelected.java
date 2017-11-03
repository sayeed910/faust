package com.tahsinsayeed.faust.presentation.event;

import com.tahsinsayeed.faust.presentation.model.CourseViewModel;

/**
 * Created by IMON on 11/3/2017.
 */
public class CourseItemSelected {
    public final CourseViewModel courseViewModel;

    public CourseItemSelected(CourseViewModel courseViewModel) {
        this.courseViewModel = courseViewModel;
    }
}
