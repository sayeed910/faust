        package com.tahsinsayeed.faust.presentation.model;

        import com.tahsinsayeed.faust.business.dto.*;
import javafx.beans.Observable;
import javafx.collections.*;

import java.util.*;
import java.util.logging.Logger;

public class ViewModelStorage {
    private static ViewModelStorage ourInstance;

    private ObservableList<CourseViewModel> courses;
    private UpcomingTasks upcomingTask;
    private Map<String, Integer> indexOfCourse;

    public static ViewModelStorage getInstance() {

        if (ourInstance == null) {
            synchronized (ViewModelStorage.class) {
                if (ourInstance == null)
                    ourInstance = new ViewModelStorage();
            }
        }

        return ourInstance;
    }

    private ViewModelStorage() {
        courses = FXCollections.observableArrayList(courseDto -> new Observable[]{
                courseDto.nameProperty(),
                courseDto.getAssignments(),
                courseDto.getExams(),
                courseDto.getBooks(),
                courseDto.getNotes()
        });
        upcomingTask = UpcomingTasks.empty();
        indexOfCourse = new Hashtable<>();
    }

    public void add(ExamDto exam) {

        if (indexOfCourse.containsKey(exam.parentCourseId)) {
            int index = indexOfCourse.get(exam.parentCourseId);
            CourseViewModel courseViewModel = courses.get(index);
            courseViewModel.getExams().add(new ExamViewModel(exam));
            courses.remove(index);
            courses.add(index, courseViewModel);
        } else {
            Logger.getGlobal().warning("Course to add exams does not exist");
        }
    }


    public void remove(ExamDto objectDto) {

    }


    public void update(ExamDto objectDto) {

    }

    public void add(AssignmentDto assignment) {

        if (indexOfCourse.containsKey(assignment.parentCourseId)) {
            int index = indexOfCourse.get(assignment.parentCourseId);
            CourseViewModel courseViewModel = courses.get(index);
            courseViewModel.getAssignments().add(new AssignmentViewModel(assignment));
            courses.remove(index);
            courses.add(index, courseViewModel);
        } else {

            Logger.getGlobal().warning("Course to add exams does not exist" + assignment.parentCourseId);
        }
    }

    public void add(BookDto book) {
        int index = indexOfCourse.get(book.parentCourseId);

        if (index != -1) {
            CourseViewModel courseViewModel = courses.get(index);
            courseViewModel.getBooks().add(new BookViewModel(book));
            courses.remove(index);
            courses.add(index, courseViewModel);
        } else {
            Logger.getGlobal().warning("Course to add exams does not exist");
        }
    }

    public void add(CourseDto course) {

        if (!indexOfCourse.containsKey(course.id)) {
            CourseViewModel courseViewModel = new CourseViewModel(course);
            courses.add(courseViewModel);
            indexOfCourse.put(course.id, courses.indexOf(courseViewModel));
            System.out.println(course.id + courses.indexOf(courseViewModel));
        } else {
            int index = indexOfCourse.get(course.id);
            courses.remove(index);
            courses.add(index, new CourseViewModel(course));
        }
    }

    public void add(NoteDto note){
        int index = indexOfCourse.get(note.parentCourseId);

        if (index != -1) {
            CourseViewModel courseViewModel = courses.get(index);
            courseViewModel.getNotes().add(new NoteViewModel(note));
            courses.remove(index);
            courses.add(index, courseViewModel);
        } else {
            Logger.getGlobal().warning("Course to add exams does not exist");
        }
    }

    public ObservableList<CourseViewModel> getCourses() {
        return courses;
    }

    public UpcomingTasks getUpcomingTask() {
        return upcomingTask;
    }


    public void add(HolidayDto holidayDto) {

    }
}
