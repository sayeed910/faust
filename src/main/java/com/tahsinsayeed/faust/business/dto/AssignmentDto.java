package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Assignment;

import java.time.LocalDate;

public class AssignmentDto {
    public final String id;
    public final String parentCourseId;
    public final String title;
    public final String description;
    public final LocalDate dueDate;
    public final boolean finished;


    private AssignmentDto(Assignment assignment){
        this.parentCourseId = assignment.getParentCourseId();
        this.title = assignment.getTitle();
        this.description = assignment.getDescription();
        this.id = assignment.getId();
        this.finished = assignment.isFinished();
        this.dueDate = assignment.getDueDate();
    }

    public static AssignmentDto from(Assignment assignment) {
        return new AssignmentDto(assignment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssignmentDto that = (AssignmentDto) o;

        if (parentCourseId != null ? !parentCourseId.equals(that.parentCourseId) : that.parentCourseId != null)
            return false;
        return title != null ? title.equals(that.title) : that.title == null;
    }

    @Override
    public int hashCode() {
        int result = parentCourseId != null ? parentCourseId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
