package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.*;
import javafx.beans.property.*;
import javafx.collections.*;

import java.util.List;
import java.util.stream.Collectors;

public class CourseDto {
    private String id;
    private StringProperty name;
    private ObservableList<BookDto> books;
    private ObservableList<Note> notes;
    private ObservableList<ExamDto> exams;
    private ObservableList<AssignmentDto> assignments;

    public CourseDto() {
    }

    public CourseDto(Course course){
        this.id =  course.getId();
        this.name = new SimpleStringProperty(course.getName());
        this.notes = FXCollections.observableArrayList(course.getNotes());
        this.books = FXCollections.observableArrayList(
                course.getBooks().stream().map(BookDto::new)
                        .collect(Collectors.toList()));
        this.exams = FXCollections.observableArrayList(
                course.getExams().stream().map(exam -> new ExamDto(exam, course.getName()))
                        .collect(Collectors.toList()));
        this.assignments = FXCollections.observableArrayList(
                course.getAssignments().stream().map(assignment -> new AssignmentDto(assignment, course.getName()))
                .collect(Collectors.toList()));
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public ObservableList<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = FXCollections.observableArrayList(books);
    }

    public ObservableList<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = FXCollections.observableArrayList(notes);
    }

    public ObservableList<ExamDto> getExams() {
        return exams;
    }

    public void setExams(List<ExamDto> exams) {
        this.exams = FXCollections.observableArrayList(exams);
    }

    public ObservableList<AssignmentDto> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<AssignmentDto> assignments) {
        this.assignments = FXCollections.observableArrayList(assignments);
    }


    public StringProperty nameProperty() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseDto courseDto = (CourseDto) o;

        return id != null ? id.equals(courseDto.id) : courseDto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
