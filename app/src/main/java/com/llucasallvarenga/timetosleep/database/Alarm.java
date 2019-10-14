package com.llucasallvarenga.timetosleep.database;

import java.io.Serializable;

public class Alarm implements Serializable {

    private int id;
    private int hourDay;
    private int miinuteDay;

    public Alarm(){}

    public Alarm(int id, int hourDay, int miinuteDay) {
        this.id = id;
        this.hourDay = hourDay;
        this.miinuteDay = miinuteDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHourDay() {
        return hourDay;
    }

    public void setHourDay(int hourDay) {
        this.hourDay = hourDay;
    }

    public int getMiinuteDay() {
        return miinuteDay;
    }

    public void setMiinuteDay(int miinuteDay) {
        this.miinuteDay = miinuteDay;
    }
}
