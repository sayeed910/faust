package com.tahsinsayeed.studykit.business.entity;

import java.util.Date;
import static java.util.Objects.requireNonNull;

public class Event {
    private final Date date;
    private String eventDescription;

    public static Event createEvent(Date date, String event){
        final Date date1 = requireNonNull(date, "Date of an eventDescription can not be null");
        final String event1 = requireNonNull(event, "For null eventDescription descriptions the other constructor should be used");

        return new Event(date1, event1);
    }

    public static Event createEvent(Date date){
        final Date date1 = requireNonNull(date, "Date of an eventDescription can not be null");

        return new Event(date1, "");
    }

    protected Event(Date date, String eventDescription) {
        this.date = date;
        this.eventDescription = eventDescription;
    }

    public Date getDate() {
        return date;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
