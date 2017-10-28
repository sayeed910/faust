package com.tahsinsayeed.faust.presentation.model;

import com.tahsinsayeed.faust.business.dto.CourseDto;
import com.tahsinsayeed.faust.business.dto.NoteDto;
import com.tahsinsayeed.faust.business.entity.*;
import javafx.beans.property.*;
import javafx.collections.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseViewModel {
    private SimpleStringProperty id;
    private StringProperty name;
    private ObservableList<BookViewModel> books;
    private ObservableList<NoteViewModel> notes;
    private ObservableList<ExamViewModel> exams;
    private ObservableList<AssignmentViewModel> assignments;

    public CourseViewModel() {
    }

    public CourseViewModel(CourseDto course){
        this.id = new SimpleStringProperty(course.id);
        this.name = new SimpleStringProperty(course.name);

        this.notes = FXCollections.observableList(course.notes.stream()
                .map(NoteViewModel::new).collect(Collectors.toCollection(ArrayList::new)));
        this.books =  FXCollections.observableList(course.books.stream()
                .map(BookViewModel::new).collect(Collectors.toCollection(ArrayList::new)));
        this.exams = FXCollections.observableList(
                course.exams.stream().map(ExamViewModel::new)
                        .collect(Collectors.toList()));
        this.assignments = FXCollections.observableList(
                course.assignments.stream().map(AssignmentViewModel::new)
                .collect(Collectors.toList()));
    }


    public SimpleStringProperty getId() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public StringProperty getName() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public ObservableList<BookViewModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookViewModel> books) {
        this.books = FXCollections.observableList(books);
    }

    public ObservableList<NoteViewModel> getNotes() {
        return notes;
    }

    public void addNote(NoteDto notes) {
        this.notes.add(new NoteViewModel(notes));
    }

    public ObservableList<ExamViewModel> getExams() {
        return exams;
    }

    public void setExams(List<ExamViewModel> exams) {
        this.exams = FXCollections.observableList(exams);
    }

    public ObservableList<AssignmentViewModel> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<AssignmentViewModel> assignments) {
        this.assignments = FXCollections.observableList(assignments);
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
