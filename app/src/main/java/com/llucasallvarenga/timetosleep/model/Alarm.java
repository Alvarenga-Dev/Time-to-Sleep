package com.llucasallvarenga.timetosleep.model;

import java.io.Serializable;

public class Alarm implements Serializable {

    private int id;
    private int hourDay;
    private int minuteDay;
    private int onAlarm;

    public Alarm(){}

    public Alarm(int onAlarm){
        this.onAlarm = onAlarm;
    }

    public Alarm(int id, int hourDay, int minuteDay) {
        this.id = id;
        this.hourDay = hourDay;
        this.minuteDay = minuteDay;
    }

    public Alarm(int id, int hourDay, int minuteDay, int onAlarm) {
        this.id = id;
        this.hourDay = hourDay;
        this.minuteDay = minuteDay;
        this.onAlarm = onAlarm;
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

    public int getMinuteDay() {
        return minuteDay;
    }

    public void setMinuteDay(int minuteDay) {
        this.minuteDay = minuteDay;
    }

    public int getOnAlarm() {
        return onAlarm;
    }

    public void setOnAlarm(int onAlarm) {
        this.onAlarm = onAlarm;
    }
}
