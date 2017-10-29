package com.tahsinsayeed.faust.presentation.model;

import com.tahsinsayeed.faust.business.dto.AssignmentDto;
import javafx.beans.property.*;
import jfxtras.scene.control.agenda.Agenda;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class AssignmentViewModel{
    private SimpleStringProperty id;
    private StringProperty parentCourseId;
    private StringProperty title;
    private StringProperty description;
    private StringProperty dueDate;
    private BooleanProperty finished;

    private Agenda.AppointmentImplLocal appointment;

    public AssignmentViewModel(AssignmentDto assignment){
        this.parentCourseId = new SimpleStringProperty(assignment.parentCourseId);
        this.title = new SimpleStringProperty(assignment.title);
        this.description = new SimpleStringProperty(assignment.description);
        this.id = new SimpleStringProperty(assignment.id);
        this.finished = new SimpleBooleanProperty(assignment.finished);
        this.dueDate = new SimpleStringProperty(assignment.dueDate.format(DateTimeFormatter.ISO_LOCAL_DATE));

        appointment  = new Agenda.AppointmentImplLocal();
        appointment.setStartLocalDateTime(LocalDateTime.of(assignment.dueDate, LocalTime.of(8, 30)));
        appointment.setWholeDay(true);
        appointment.setSummary(assignment.parentCourseId + " " + assignment.title);

    }

    public StringProperty getId() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }



    public StringProperty getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty getParentCourseId() {
        return parentCourseId;
    }

    public void setParentCourseId(String parentCourseId) {
        this.parentCourseId.set(parentCourseId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssignmentViewModel that = (AssignmentViewModel) o;

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

    public boolean isFinished() {
        return finished.get();
    }

    public BooleanProperty finishedProperty() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished.set(finished);
    }

    public String getDueDate() {
        return dueDate.get();
    }

    public StringProperty dueDateProperty() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate.set(dueDate);
    }

    public Agenda.AppointmentImplLocal getAppointment(){
        return appointment;
    }
}
