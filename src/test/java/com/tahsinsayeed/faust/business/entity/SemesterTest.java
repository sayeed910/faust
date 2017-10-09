package com.tahsinsayeed.faust.business.entity;

import javafx.beans.property.*;
import org.junit.*;

import java.time.*;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class SemesterTest {

    private LocalDate endDate;
    private Semester semester;

    @Before
    public void createSemester() throws Exception {
        LocalDate startDate = LocalDate.now();
        endDate = LocalDate.of(2017, Month.AUGUST, 2);
        semester = Semester.getInstance("Fall-2017", startDate,
                endDate);

    }
    @Test
    public void afterAddingTheCourseCanBeFound() throws Exception {
        Course computer_studies = addCourse();
        assertThat(semester.findCourseById("CSE-2301"), equalTo(computer_studies));

    }



    private Course addCourse() throws Semester.CourseConflict {
        Course computer_studies = Course.create("CSE-2301", "Computer Studies");
        semester.addCourse(computer_studies);
        return computer_studies;
    }

    @Test(expected = Semester.CourseConflict.class)
    public void TwoCoursesWithSameIdThrows() throws Exception {
        addCourse();
        addCourse();
    }

    @Test
    public void observable() throws Exception {
        IntegerProperty integer = new SimpleIntegerProperty(5);
        IntegerProperty another = new SimpleIntegerProperty(5);

        another.bind(integer);
        integer = new SimpleIntegerProperty(7);

        assertEquals(another.intValue(), 7);
    }



    }


