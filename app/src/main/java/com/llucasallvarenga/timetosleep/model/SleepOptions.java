package com.llucasallvarenga.timetosleep.model;

public class SleepOptions {

    private String minutes;

    public SleepOptions(String minutes) {
        this.minutes = minutes;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }
}
