package com.tahsinsayeed.studykit.model;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class Schedule {
    List<Holiday> holidays;
    List<Event> events;
    List<Class> classes;

    public Schedule(List<Holiday> holidays, List<Event> events, List<Class> classes) {
        this.holidays = holidays;
        this.events = events;
        this.classes = classes;
    }

    public Schedule() {
    }

    public List<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public void addClass(Class clazz){
        classes.add(checkNotNull(clazz));
    }
    public void removeClass(Class clazz){
        classes.remove(checkNotNull(clazz));
    }
    public void addEvent(Event event){
        events.add(checkNotNull(event));
    }
    public void removeEvent(Event event){
        events.remove(checkNotNull(event));
    }
    public void addHoliday(Holiday holiday){
        holidays.add(checkNotNull(holiday));
    }
    public void removeHoliday(Holiday holiday){
        holidays.remove(checkNotNull(holiday));
    }
}
