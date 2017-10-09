package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.*;

import java.util.List;
import java.util.stream.Collectors;

public class CourseDto {
    private String id;
    private String name;
    private List<Book> books;
    private List<Note> notes;
    private List<ExamDto> exams;
    private List<AssignmentDto> assignments;

    public CourseDto() {
    }

    public CourseDto(Course course){
        this.id = course.getId();
        this.name = course.getName();
        this.books = course.getBooks();
        this.notes = course.getNotes();
        this.exams = course.getExams().stream().map(exam -> new ExamDto(exam, name)).collect(Collectors.toList());
        this.assignments = course.getAssignments().stream().map(assignment -> new AssignmentDto(assignment, name))
                .collect(Collectors.toList());
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<ExamDto> getExams() {
        return exams;
    }

    public void setExams(List<ExamDto> exams) {
        this.exams = exams;
    }

    public List<AssignmentDto> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<AssignmentDto> assignments) {
        this.assignments = assignments;
    }
}
