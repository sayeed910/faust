package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.Course;
import com.tahsinsayeed.faust.business.request.ChangeCourseRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;

/**
 * Created by IMON on 11/3/2017.
 */
public class ChangeCourseInteractor implements Interactor {
    private final Repository<Course> courseRepository;

    public ChangeCourseInteractor(Repository<Course> courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void execute(Request request) {
        ChangeCourseRequest courseRequest = (ChangeCourseRequest) request;
        Course course = courseRepository.get(courseRequest.id);

        course.setName(courseRequest.name);

        courseRepository.update(course);

    }
}
