package com.llucasallvarenga.timetosleep.database;

import android.content.Context;

import com.llucasallvarenga.timetosleep.utils.Preferences;

import java.io.Serializable;

public class Alarm implements Serializable {

    private int id;
    private int hourDay;
    private int minuteDay;

    public Alarm(){}

    public Alarm(int id, int hourDay, int minuteDay) {
        this.id = id;
        this.hourDay = hourDay;
        this.minuteDay = minuteDay;
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

    public boolean isOnAlarm(Context context) {
        Preferences preferences = new Preferences(context);
        return preferences.getOnAlarm();
    }

}
