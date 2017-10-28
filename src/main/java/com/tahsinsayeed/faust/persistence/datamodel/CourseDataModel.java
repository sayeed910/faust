package com.tahsinsayeed.faust.persistence.datamodel;

import com.tahsinsayeed.faust.business.dto.CourseDto;

import java.util.List;
import java.util.stream.Collectors;

public class CourseDataModel {
    private String id;
    private String name;
    private List<BookDataModel> books;
    private List<NoteDataModel> notes;
    private List<ExamDataModel> exams;
    private List<AssignmentDataModel> assignments;

    public CourseDataModel() {
    }

    public CourseDataModel(CourseDto course) {
        this.id = course.id;
        this.name = course.name;
        this.notes = course.notes.stream().map(NoteDataModel::new).collect(Collectors.toList());
        this.books = course.books.stream().map(BookDataModel::new).collect(Collectors.toList());
        this.exams = course.exams.stream().map(ExamDataModel::new).collect(Collectors.toList());
        this.assignments = course.assignments.stream().map(AssignmentDataModel::new).collect(Collectors.toList());
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

    public List<BookDataModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookDataModel> books) {
        this.books = (books);
    }

    public List<NoteDataModel> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteDataModel> notes) {
        this.notes = (notes);
    }

    public List<ExamDataModel> getExams() {
        return exams;
    }

    public void setExams(List<ExamDataModel> exams) {
        this.exams = (exams);
    }

    public List<AssignmentDataModel> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<AssignmentDataModel> assignments) {
        this.assignments = (assignments);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseDataModel courseDto = (CourseDataModel) o;

        return id != null ? id.equals(courseDto.id) : courseDto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
