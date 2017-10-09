package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.*;
import javafx.collections.*;

import java.util.*;
import java.util.logging.Logger;

public class DtoBank {
    private static DtoBank ourInstance;

    private ObservableList<CourseDto> courses;
    private UpcomingTask upcomingTask;
    private Map<String, Integer> indexOfCourse;

    public static DtoBank getInstance() {

        if (ourInstance == null){
            synchronized (DtoBank.class){
                if (ourInstance == null)
                    ourInstance = new DtoBank();
            }
        }

        return ourInstance;
    }

    private DtoBank() {
        courses = FXCollections.observableArrayList();
        upcomingTask = new UpcomingTask();
        indexOfCourse = new Hashtable<>();
    }

    public void addExam(ExamDto exam){
        int index = indexOfCourse.get(exam.getParentCourseId());

        if (index != -1){
            CourseDto courseDto = courses.get(index);
            courseDto.getExams().add(exam);
            courses.add(index, courseDto);
        } else {
            Logger.getGlobal().warning("Course to add exams does not exist");
        }

    }

    public void addAssignment(AssignmentDto assignment){
        int index = indexOfCourse.get(assignment.getParentCourseId());

        if (index != -1){
            CourseDto courseDto = courses.get(index);
            courseDto.getAssignments().add(assignment);
            courses.add(index, courseDto);
        } else {
            Logger.getGlobal().warning("Course to add exams does not exist");
        }

    }

    public void addBook(BookDto book){
        int index = indexOfCourse.get(book.getParentCourseId());

        if (index != -1){
            CourseDto courseDto = courses.get(index);
            courseDto.getBooks().add(book);
            courses.add(index, courseDto);
        } else {
            Logger.getGlobal().warning("Course to add exams does not exist");
        }

    }

    public void addCourse(CourseDto course){
        int index = indexOfCourse.get(course.getId());

        if (index == -1){
            courses.add(course);
            indexOfCourse.put(course.getId(), courses.indexOf(course));
        } else {
            courses.add(index, course);
        }
    }

    public ObservableList<CourseDto> getCourses() {
        return courses;
    }

    public UpcomingTask getUpcomingTask() {
        return upcomingTask;
    }

    public void setUpcomingTask(UpcomingTask aUpcomingTask) {
        this.upcomingTask.setUpcomingClasses(aUpcomingTask.getUpcomingClasses());
        this.upcomingTask.setUpcomingAssignments(aUpcomingTask.getUpcomingAssignments());
        this.upcomingTask.setUpcomingExams(aUpcomingTask.getUpcomingExams());

    }
}
