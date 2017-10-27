package com.tahsinsayeed.faust.business.entity;

import com.google.common.annotations.VisibleForTesting;

import java.util.*;

import static com.google.common.base.Preconditions.checkNotNull;

public class Schedule {
    List<Holiday> holidays;
    List<Class> classes;


    private Schedule(List<Holiday> holidays, List<Class> classes) {
        this.holidays = holidays;
        this.classes = classes;
    }


    public static Schedule create() {
        return new Schedule(new ArrayList<Holiday>(), new ArrayList<Class>());
    }


    @VisibleForTesting
    static Schedule create(List<Holiday> holidays, List<Class> classes) {
        return new Schedule(holidays, classes);
    }

    public List<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }



    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public void addClass(Class clazz) {
        classes.add(checkNotNull(clazz));
    }

    public void removeClass(Class clazz) {
        classes.remove(checkNotNull(clazz));
    }



    public void addHoliday(Holiday holiday) {
        holidays.add(checkNotNull(holiday));
    }

    public void removeHoliday(Holiday holiday) {
        holidays.remove(checkNotNull(holiday));
    }
}
