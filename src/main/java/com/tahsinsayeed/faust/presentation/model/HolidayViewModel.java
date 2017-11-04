package com.tahsinsayeed.faust.presentation.model;

import com.tahsinsayeed.faust.business.dto.HolidayDto;
import javafx.beans.property.*;
import jfxtras.scene.control.agenda.Agenda;

import java.time.*;

/**
 * Created by sayeed on 10/25/17.
 */
public class HolidayViewModel {
    private Agenda.AppointmentImplLocal appointment;
    private StringProperty name;
    private LocalDate date;

    public HolidayViewModel() {

    }

    public HolidayViewModel(HolidayDto holiday) {
        this.name = new SimpleStringProperty(holiday.name);
        this.date = holiday.date;

        appointment = new Agenda.AppointmentImplLocal();
        appointment.setStartLocalDateTime(LocalDateTime.of(holiday.date, LocalTime.of(8, 30)));
        appointment.setWholeDay(true);
        appointment.setSummary(holiday.name);
    }

    public StringProperty getName() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Agenda.AppointmentImplLocal getAppointment() {
        return appointment;
    }
}
