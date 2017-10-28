        package com.tahsinsayeed.faust.presentation.model;

        import com.tahsinsayeed.faust.business.dto.UpcomingTasks;
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
        upcomingTask = UpcomingTasks.from();
        indexOfCourse = new Hashtable<>();
    }

    public void addExam(ExamViewModel exam) {

        if (indexOfCourse.containsKey(exam.getParentCourseId())) {
            int index = indexOfCourse.get(exam.getParentCourseId());
            CourseViewModel courseDto = courses.get(index);
            courseDto.getExams().add(exam);
            courses.remove(index);
            courses.add(index, courseDto);
        } else {
            Logger.getGlobal().warning("Course to add exams does not exist");
        }
    }

    public void addAssignment(AssignmentViewModel assignment) {

        if (indexOfCourse.containsKey(assignment.getParentCourseId())) {
            int index = indexOfCourse.get(assignment.getParentCourseId());
            CourseViewModel courseDto = courses.get(index);
            courseDto.getAssignments().add(assignment);
            courses.remove(index);
            courses.add(index, courseDto);
        } else {

            Logger.getGlobal().warning("Course to add exams does not exist" + assignment.getParentCourseId());
        }
    }

    public void addBook(BookViewModel book) {
        int index = indexOfCourse.get(book.getParentCourseId());

        if (index != -1) {
            CourseViewModel courseDto = courses.get(index);
            courseDto.getBooks().add(book);
            courses.add(index, courseDto);
        } else {
            Logger.getGlobal().warning("Course to add exams does not exist");
        }
    }

    public void addCourse(CourseViewModel course) {

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

    public ObservableList<CourseViewModel> getCourses() {
        return courses;
    }

    public UpcomingTasks getUpcomingTask() {
        return upcomingTask;
    }

    public void setUpcomingTask(UpcomingTasks aUpcomingTask) {
        this.upcomingTask.setUpcomingClasses(aUpcomingTask.getUpcomingClasses());
        this.upcomingTask.setUpcomingAssignments(aUpcomingTask.getUpcomingAssignments());
        this.upcomingTask.setUpcomingExams(aUpcomingTask.getUpcomingExams());
    }
}
