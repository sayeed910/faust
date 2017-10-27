package com.tahsinsayeed.faust.business.dto;

import javafx.beans.Observable;
import javafx.collections.*;
import javafx.util.Callback;

import java.util.*;
import java.util.logging.Logger;

public class DtoBank {
    private static DtoBank ourInstance;

    private ObservableList<CourseDto> courses;
    private UpcomingTask upcomingTask;
    private Map<String, Integer> indexOfCourse;

    public static DtoBank getInstance() {

        if (ourInstance == null) {
            synchronized (DtoBank.class) {
                if (ourInstance == null)
                    ourInstance = new DtoBank();
            }
        }

        return ourInstance;
    }

    private DtoBank() {
        courses = FXCollections.observableArrayList(new Callback<CourseDto, javafx.beans.Observable[]>() {
            @Override
            public Observable[] call(CourseDto courseDto) {
                return new Observable[]{
                        courseDto.nameProperty(),
                        courseDto.getAssignments(),
                        courseDto.getExams(),
                        courseDto.getBooks(),
                        courseDto.getNotes()
                };
            }
        });
        upcomingTask = new UpcomingTask();
        indexOfCourse = new Hashtable<>();
    }

    public void addExam(ExamDto exam) {

        if (indexOfCourse.containsKey(exam.getParentCourseId())) {
            int index = indexOfCourse.get(exam.getParentCourseId());
            CourseDto courseDto = courses.get(index);
            courseDto.getExams().add(exam);
            courses.remove(index);
            courses.add(index, courseDto);
        } else {
            Logger.getGlobal().warning("Course to add exams does not exist");
        }
    }

    public void addAssignment(AssignmentDto assignment) {

        if (indexOfCourse.containsKey(assignment.getParentCourseId())) {
            int index = indexOfCourse.get(assignment.getParentCourseId());
            CourseDto courseDto = courses.get(index);
            courseDto.getAssignments().add(assignment);
            courses.remove(index);
            courses.add(index, courseDto);
        } else {

            Logger.getGlobal().warning("Course to add exams does not exist" + assignment.getParentCourseId());
        }
    }

    public void addBook(BookDto book) {
        int index = indexOfCourse.get(book.getParentCourseId());

        if (index != -1) {
            CourseDto courseDto = courses.get(index);
            courseDto.getBooks().add(book);
            courses.add(index, courseDto);
        } else {
            Logger.getGlobal().warning("Course to add exams does not exist");
        }
    }

    public void addCourse(CourseDto course) {

        if (!indexOfCourse.containsKey(course.getId())) {
            courses.add(course);
            indexOfCourse.put(course.getId(), courses.indexOf(course));
            System.out.println(course.getId() + courses.indexOf(course));
        } else {
            int index = indexOfCourse.get(course.getId());
            courses.remove(index);
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
