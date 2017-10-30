        package com.tahsinsayeed.faust.presentation.model;

        import com.tahsinsayeed.faust.business.dto.*;
        import javafx.beans.Observable;
        import javafx.collections.*;
        import javafx.util.Callback;

        import java.util.*;
        import java.util.logging.Logger;

public class DtoBank {
    private static DtoBank ourInstance;

    private ObservableList<CourseViewModel> courses;
    private UpcomingTasks upcomingTask;
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
        courses = FXCollections.observableArrayList(new Callback<CourseViewModel, javafx.beans.Observable[]>() {
            @Override
            public Observable[] call(CourseViewModel courseDto) {
                return new Observable[]{
                        courseDto.nameProperty(),
                        courseDto.getAssignments(),
                        courseDto.getExams(),
                        courseDto.getBooks(),
                        courseDto.getNotes()
                };
            }
        });
        upcomingTask = UpcomingTasks.empty();
        indexOfCourse = new Hashtable<>();
    }

    public void addExam(ExamDto exam) {

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

    public void addAssignment(AssignmentDto assignment) {

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

    public void addBook(BookDto book) {
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

    public void addCourse(CourseDto course) {

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

    public ObservableList<CourseViewModel> getCourses() {
        return courses;
    }

    public UpcomingTasks getUpcomingTask() {
        return upcomingTask;
    }


}
