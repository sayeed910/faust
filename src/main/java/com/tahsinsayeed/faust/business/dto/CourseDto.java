package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Course;

import java.util.List;
import java.util.stream.Collectors;

public class CourseDto {
    public final String id;
    public final String name;
    public final List<BookDto> books;
    public final List<NoteDto> notes;
    public final List<ExamDto> exams;
    public final List<AssignmentDto> assignments;

    public CourseDto(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.notes = course.getNotes().stream().map(NoteDto::from).collect(Collectors.toList());
        this.books = course.getBooks().stream().map(BookDto::from).collect(Collectors.toList());
        this.exams = course.getExams().stream().map(ExamDto::from).collect(Collectors.toList());
        this.assignments = course.getAssignments().stream().map(AssignmentDto::from).collect(Collectors.toList());
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
