package com.tahsinsayeed.faust.persistence.mapper;

import com.google.inject.Inject;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.persistence.datamodel.*;
import com.tahsinsayeed.faust.persistence.repository.DataModelToEntityMapper;

/**
 * Created by sayeed on 10/28/17.
 */
public class CourseMapper implements DataModelToEntityMapper<CourseDataModel, Course> {

    private BookMapper bookMapper;
    private AssignmentMapper assignmentMapper;
    private ExamMapper examMapper;
    private NoteMapper noteMapper;

    @Inject
    public CourseMapper(BookMapper bookMapper, AssignmentMapper assignmentMapper, ExamMapper examMapper, NoteMapper noteMapper) {
        this.bookMapper = bookMapper;
        this.assignmentMapper = assignmentMapper;
        this.examMapper = examMapper;
        this.noteMapper = noteMapper;
    }

    public CourseMapper(){
        bookMapper = new BookMapper();
        assignmentMapper = new AssignmentMapper();
        examMapper = new ExamMapper();
        noteMapper = new NoteMapper();
    }

    @Override
    public Course map(CourseDataModel dataModel) {
        Course course = Course.create(dataModel.getId(), dataModel.getName());

        for (BookDataModel book : dataModel.getBooks())
            course.addBook(bookMapper.map(book));

        for (AssignmentDataModel assignment: dataModel.getAssignments())
            course.addAssignment(assignmentMapper.map(assignment));

        for (ExamDataModel exam: dataModel.getExams())
            course.addExam(examMapper.map(exam));

        for (NoteDataModel note: dataModel.getNotes())
            course.addNote(noteMapper.map(note));

       return course;

    }
}
