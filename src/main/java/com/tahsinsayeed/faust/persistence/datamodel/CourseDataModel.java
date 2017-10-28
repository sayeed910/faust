package com.tahsinsayeed.faust.persistence.datamodel;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.tahsinsayeed.faust.business.dto.CourseDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@DatabaseTable(tableName = "CourseDataModel")
public class CourseDataModel {

    @DatabaseField(id = true)
    private String id;

    @DatabaseField
    private String name;

    @ForeignCollectionField
    Collection<BookDataModel> books;

    @ForeignCollectionField
    Collection<NoteDataModel> notes;

    @ForeignCollectionField
    Collection<ExamDataModel> exams;

    @ForeignCollectionField
    Collection<AssignmentDataModel> assignments;

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
        return new ArrayList<>(books);
    }

    public void setBooks(List<BookDataModel> books) {
        this.books = (books);
    }

    public List<NoteDataModel> getNotes() {
        return new ArrayList<>(notes);
    }

    public void setNotes(List<NoteDataModel> notes) {
        this.notes = (notes);
    }

    public List<ExamDataModel> getExams() {
        return new ArrayList<>(exams);
    }

    public void setExams(List<ExamDataModel> exams) {
        this.exams = (exams);
    }

    public List<AssignmentDataModel> getAssignments() {
        return new ArrayList<>(assignments);
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
