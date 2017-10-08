package com.tahsinsayeed.faust.business.entity;

public class Attendance {
    private int classHeld;
    private int classAttended;


    public int getClassHeld() {
        return classHeld;
    }

    public void setClassHeld(int classHeld) {
        this.classHeld = classHeld;
    }

    public int getClassAttended() {
        return classAttended;
    }

    public void setClassAttended(int classAttended) {
        this.classAttended = classAttended;
    }


    public void attend(){
        classHeld++;
        classAttended++;
    }
    public void skip(){
        classHeld++;
    }

    public double getAttendancePercentage(){
        return (classHeld != 0) ? (double)classAttended/classHeld : 0.00;
    }
}
