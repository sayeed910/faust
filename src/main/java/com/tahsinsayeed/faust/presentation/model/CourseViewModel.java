package com.tahsinsayeed.faust.presentation.model;

import com.tahsinsayeed.faust.business.entity.*;
import javafx.beans.property.*;
import javafx.collections.*;

import java.util.List;
import java.util.stream.Collectors;

public class CourseViewModel {
    private String id;
    private StringProperty name;
    private ObservableList<BookViewModel> books;
    private ObservableList<NoteViewModel> notes;
    private ObservableList<ExamViewModel> exams;
    private ObservableList<AssignmentViewModel> assignments;

    public CourseViewModel() {
    }

    public CourseViewModel(Course course){
        this.id =  course.getId();
        this.name = new SimpleStringProperty(course.getName());
        this.notes = FXCollections.observableArrayList(course.getNotes());
        this.books = FXCollections.observableArrayList(
                course.getBooks().stream().map(BookViewModel::new)
                        .collect(Collectors.toList()));
        this.exams = FXCollections.observableArrayList(
                course.getExams().stream().map(exam -> new ExamViewModel(exam, course))
                        .collect(Collectors.toList()));
        this.assignments = FXCollections.observableArrayList(
                course.getAssignments().stream().map(assignment -> new AssignmentViewModel(assignment, course))
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

    public ObservableList<BookViewModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookViewModel> books) {
        this.books = FXCollections.observableArrayList(books);
    }

    public ObservableList<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = FXCollections.observableArrayList(notes);
    }

    public ObservableList<ExamViewModel> getExams() {
        return exams;
    }

    public void setExams(List<ExamViewModel> exams) {
        this.exams = FXCollections.observableArrayList(exams);
    }

    public ObservableList<AssignmentViewModel> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<AssignmentViewModel> assignments) {
        this.assignments = FXCollections.observableArrayList(assignments);
    }


    public StringProperty nameProperty() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseViewModel courseDto = (CourseViewModel) o;

        return id != null ? id.equals(courseDto.id) : courseDto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
