package com.tahsinsayeed.faust.business.entity;

import com.google.common.annotations.VisibleForTesting;

import java.util.*;

public class Course {
    private String id;
    private String name;
    private List<Book> books;
    private Notebook notebook;
    private List<Exam> exams;
    private List<Assignment> assignments;

    public static Course create(String id, String name){
        return new Course(id, name, new ArrayList<>(), Notebook.create(), new ArrayList<>(), new ArrayList<>());

    }

    @VisibleForTesting
    static Course create(String id, String name, List<Book> books,
                         Notebook notebook, List<Exam> exams, List<Assignment> assignments){
        return new Course(id, name, books, notebook, exams, assignments);

    }

    private Course(String id, String name, List<Book> books, Notebook notebook, List<Exam> exams, List<Assignment> assignments){
        this.id = id;
        this.name = name;
        this.books = books;
        this.notebook = notebook;
        this.exams = exams;
        this.assignments = assignments;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (!id.equals(course.id)) return false;
        return name.equals(course.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    public void addExam(Exam exam) {
        this.exams.add(exam);
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void addAssignment(Assignment assignment) {
        this.assignments.add(assignment);
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }
}
