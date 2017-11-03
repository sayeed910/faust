package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.Course;
import com.tahsinsayeed.faust.business.entity.Course;
import com.tahsinsayeed.faust.business.request.RemoveCourseRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;

/**
 * Created by IMON on 11/3/2017.
 */
public class RemoveCourseInteractor implements Interactor {
    private final Repository<Course> courseRepository;

    public RemoveCourseInteractor(Repository<Course> courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void execute(Request request) {
        RemoveCourseRequest courseRequest = (RemoveCourseRequest) request;

        Course course = courseRepository.get(courseRequest.id);
        courseRepository.delete(course);

    }
}