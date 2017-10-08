package com.tahsinsayeed.faust.persistence;

import com.google.common.collect.*;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.entity.Class;

import java.time.*;
import java.util.*;


public class MemoryDatabase {
    public static Map<String, Course> courses = Maps.newHashMap();
    public static Map<String, Assignment> assignments = new Hashtable<>();
    public static Map<String, Class> classes = new Hashtable<>();
    public static Map<String, Schedule> schedules = new Hashtable<>();
    //all classes in com.tahsinsayeed.faust.business.entity will have a map;

    static {
        Assignment assignment1 = Assignment.createWithDescription("CSE-3201",
                "Assignment1", "lorem ipsum", LocalDate.now());
        Assignment assignment2 = Assignment.createWithDescription("CSE-3202",
                "Assignment2", "lorem ipsum", LocalDate.of(2017, 10, 11));

        assignments.put(assignment1.getId(), assignment1);
        assignments.put(assignment2.getId(), assignment2);

        Class clazz1 = Class.create("CSE-3201", DayOfWeek.MONDAY, LocalTime.of(10, 0));
        //classes which don't have ID field will use randomUUID for key.
        classes.put(UUID.randomUUID().toString(), clazz1);


        Course course1 = Course.create("CSE-3201", "Software Design Patterns"); //or whatever the name is
        Course course2 = Course.create("CSE-3201", "System Programming"); //or whatever the name is

        course1.addAssignment(assignment1);
        course2.addAssignment(assignment2);

        courses.put(course1.getId(), course1);
        courses.put(course2.getId(), course2);

        Schedule schedule = Schedule.create();
        schedule.addClass(clazz1);

        schedules.put(UUID.randomUUID().toString(), schedule);


    }

}
