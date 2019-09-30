package com.llucasallvarenga.timetosleep.utils;

import java.util.Calendar;

public class Clock {

    Calendar cal = Calendar.getInstance();

    private int AlarmHour = cal.get(Calendar.HOUR) ;
    private int AlarmMinutes = cal.get(Calendar.MINUTE) ;
    private int AlarmDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

    private String valueDayOfWeek(){

        String valueTextDayOfWeek = "";

        switch (AlarmDayOfWeek) {
            case 1:
                valueTextDayOfWeek = "Domingo";
                break;
            case 2:
                valueTextDayOfWeek = "Segunda";
                break;
            case 3:
                valueTextDayOfWeek = "Terça";
                break;
            case 4:
                valueTextDayOfWeek = "Quarta";
                break;
            case 5:
                valueTextDayOfWeek = "Quinta";
                break;
            case 6:
                valueTextDayOfWeek = "Sexta";
                break;
            case 7:
                valueTextDayOfWeek = "Sábado";
                break;
        }
        return valueTextDayOfWeek;
    }

    public String getAlarmHour() {
        return String.valueOf(AlarmHour);
    }

    public String getAlarmMinutes() {
        return String.valueOf(AlarmMinutes);
    }

    public String getAlarmDayOfWeek() {
        return valueDayOfWeek();
    }
}
