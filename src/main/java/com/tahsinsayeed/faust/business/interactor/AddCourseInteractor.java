package com.tahsinsayeed.faust.business.interactor;

import com.google.inject.Inject;
import com.tahsinsayeed.faust.business.dto.CourseDto;
import com.tahsinsayeed.faust.business.entity.Course;
import com.tahsinsayeed.faust.business.request.NewCourseRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;
import com.tahsinsayeed.faust.presentation.model.ViewModelStorage;

public class AddCourseInteractor implements Interactor {

    private Repository<Course> courseRepository;

    @Inject
    public AddCourseInteractor(Repository<Course> courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void execute(Request request) {

        NewCourseRequest courseRequest = (NewCourseRequest) request;

        Course course = Course.create(courseRequest.courseId, courseRequest.courseName);
        courseRepository.save(course);

        CourseDto courseDto = new CourseDto(course);
        ViewModelStorage.getInstance().add(courseDto);
    }

}
