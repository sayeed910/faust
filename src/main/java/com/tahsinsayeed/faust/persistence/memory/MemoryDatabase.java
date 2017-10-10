package com.tahsinsayeed.faust.persistence.memory;

import com.google.common.collect.*;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.entity.Class;

import java.io.File;
import java.time.*;
import java.util.*;


public class MemoryDatabase {
    public static Map<String, Attendance> attendance = new Hashtable<>();
    public static Map<String, Assignment> assignments = new Hashtable<>();
    public static Map<String, Book> book = new Hashtable<>();
    public static Map<String, Course> courses = Maps.newHashMap();
    public static Map<String, Class> classes = new Hashtable<>();
    public static Map<String, Event> events = new Hashtable<>();
    public static Map<String, Exam> exams = new Hashtable<>();
    public static Map<String, Holiday> holidays = new Hashtable<>();
    public static Map<String, Note> notebook = new Hashtable<>();
    public static Map<String, Schedule> schedules = new Hashtable<>();
    public static Map<String, Semester> semester = new Hashtable<>();


    static {
        Assignment assignment1 = Assignment.createWithDescription("CSE-3201",
                "Assignment1", "Design a Softwer", LocalDate.now());
        Assignment assignment2 = Assignment.createWithDescription("CSE-3202",
                "Assignment2", "Create a Http Server", LocalDate.of(2017, 10, 10));
        Assignment assignment3 = Assignment.createWithDescription("CSE-3202",
                "Assignment3", "Draw a DFA", LocalDate.of(2017, 10, 01));
        Assignment assignment4 = Assignment.createWithDescription("CSE-3202",
                "Assignment4", "Write a C code", LocalDate.of(2017, 10, 14));
        Assignment assignment5 = Assignment.createWithDescription("CSE-3202",
                "Assignment5", "Matrics and Vector", LocalDate.of(2017, 10, 10));

        assignments.put(assignment1.getId(), assignment1);
        assignments.put(assignment2.getId(), assignment2);
        assignments.put(assignment3.getId(), assignment3);
        assignments.put(assignment4.getId(), assignment4);

        assignments.put(assignment5.getId(), assignment5);
        final String HOME_DIR= System.getProperty("user.dir")+ File.separator + ".faust"+File.separator;

        Book book11= Book.create("Head First Design","CSE-3201",
                new File(HOME_DIR+"Head First Java.pdf"));
        Book book12= Book.create("Design Pattern","CSE-3201",
                new File(HOME_DIR+"Design Pattern.pdf"));
        Book book21= Book.create("Computer Networking","CSE-3202",
                new File(HOME_DIR+"Compter Netwoking.pdf"));
        Book book31= Book.create("Finite Automata","CSE-3203",
                new File(HOME_DIR+"Finite Automata.pdf"));
        Book book32= Book.create("Automata","CSE-3203",
                new File(HOME_DIR+"Automata.pdf"));

        Book book41= Book.create("Linux System Programming","CSE-3204",
                new File(HOME_DIR+"Head First Java.pdf"));
        Book book51= Book.create("Boyd_VMLS","CSE-3205",
                new File(HOME_DIR+"Boyd_VMLS.pdf"));
        Book book52= Book.create("Inner-products_orthogonality","CSE-3205",
                new File(HOME_DIR+"inner-products_orthogonality.pdf"));

        book.put(UUID.randomUUID().toString(), book11);
        book.put(UUID.randomUUID().toString(), book12);
        book.put(UUID.randomUUID().toString(), book21);
        book.put(UUID.randomUUID().toString(), book31);
        book.put(UUID.randomUUID().toString(), book32);
        book.put(UUID.randomUUID().toString(), book41);
        book.put(UUID.randomUUID().toString(), book51);
        book.put(UUID.randomUUID().toString(), book52);



        Exam exam1 =Exam.create("Semester Final","CSE-3201",
                LocalDate.of(2017, 11, 20),LocalTime.of(10, 0));
        Exam exam2 =Exam.create("Semester Final","CSE-3202",
                LocalDate.of(2017, 11, 24),LocalTime.of(10, 0));
        Exam exam3 =Exam.create("Semester Final","CSE-3203",
                LocalDate.of(2017, 11, 28),LocalTime.of(10, 0));
        Exam exam4 =Exam.create("Semester Final","CSE-3204",
                LocalDate.of(2017, 12, 2),LocalTime.of(10, 0));
        Exam exam5 =Exam.create("Semester Final","CSE-3205",
                LocalDate.of(2017, 12, 7),LocalTime.of(10, 0));

        //exams which don't have ID field will use randomUUID for key.
        exams.put(UUID.randomUUID().toString(), exam1);
        exams.put(UUID.randomUUID().toString(), exam2);
        exams.put(UUID.randomUUID().toString(), exam3);
        exams.put(UUID.randomUUID().toString(), exam4);
        exams.put(UUID.randomUUID().toString(), exam5);

        Class clazz11 = Class.create("CSE-3201", DayOfWeek.WEDNESDAY, LocalTime.of(11, 30));
        Class clazz12 = Class.create("CSE-3201", DayOfWeek.THURSDAY, LocalTime.of(8, 30));

        Class clazz21 = Class.create("CSE-3202", DayOfWeek.MONDAY, LocalTime.of(10, 0));
        Class clazz22 = Class.create("CSE-3202", DayOfWeek.WEDNESDAY, LocalTime.of(10, 0));

        Class clazz31 = Class.create("CSE-3203", DayOfWeek.MONDAY, LocalTime.of(11, 30));
        Class clazz32 = Class.create("CSE-3203", DayOfWeek.THURSDAY, LocalTime.of(11, 30));

        Class clazz41 = Class.create("CSE-3204", DayOfWeek.SUNDAY, LocalTime.of(10, 0));
        Class clazz42 = Class.create("CSE-3204", DayOfWeek.THURSDAY, LocalTime.of(10, 0));

        Class clazz51 = Class.create("CSE-3205", DayOfWeek.MONDAY, LocalTime.of(2, 0));
        Class clazz52 = Class.create("CSE-3205", DayOfWeek.WEDNESDAY, LocalTime.of(2, 0));
        //classes which don't have ID field will use randomUUID for key.
        classes.put(UUID.randomUUID().toString(), clazz11);
        classes.put(UUID.randomUUID().toString(), clazz12);
        classes.put(UUID.randomUUID().toString(), clazz21);
        classes.put(UUID.randomUUID().toString(), clazz22);
        classes.put(UUID.randomUUID().toString(), clazz31);
        classes.put(UUID.randomUUID().toString(), clazz32);
        classes.put(UUID.randomUUID().toString(), clazz41);
        classes.put(UUID.randomUUID().toString(), clazz42);
        classes.put(UUID.randomUUID().toString(), clazz51);
        classes.put(UUID.randomUUID().toString(), clazz52);


        Course course1 = Course.create("CSE-3201", "Software Design Patterns"); //or whatever the name is
        Course course2 = Course.create("CSE-3202", "Computer Networking"); //or whatever the name is
        Course course3 = Course.create("CSE-3203", "Finite Language, Automata and Computation"); //or whatever the name is
        Course course4 = Course.create("CSE-3204", "System Programming"); //or whatever the name is
        Course course5 = Course.create("CSE-3205", "Mathematics for Computer Science"); //or whatever the name is

        course1.addAssignment(assignment1);
        course2.addAssignment(assignment2);
        course3.addAssignment(assignment3);
        course4.addAssignment(assignment4);
        course5.addAssignment(assignment5);

        course1.addBook(book11);
        course1.addBook(book12);
        course2.addBook(book21);
        course3.addBook(book31);
        course3.addBook(book32);
        course4.addBook(book41);
        course5.addBook(book51);
        course5.addBook(book52);


        course1.addExam(exam1);
        course2.addExam(exam2);
        course3.addExam(exam3);
        course4.addExam(exam4);
        course5.addExam(exam5);

        courses.put(course1.getId(), course1);
        courses.put(course2.getId(), course2);
        courses.put(course3.getId(), course3);
        courses.put(course4.getId(), course4);
        courses.put(course5.getId(), course5);

        Schedule schedule = Schedule.create();
        schedule.addClass(clazz11);
        schedule.addClass(clazz12);
        schedule.addClass(clazz21);
        schedule.addClass(clazz22);
        schedule.addClass(clazz31);
        schedule.addClass(clazz32);
        schedule.addClass(clazz41);
        schedule.addClass(clazz42);
        schedule.addClass(clazz51);
        schedule.addClass(clazz52);

        schedules.put(UUID.randomUUID().toString(), schedule);


    }

}

