package com.llucasallvarenga.timetosleep.utils;

import java.util.Calendar;

public class Data {

    public Data() {
    }

    private Calendar calendar = Calendar.getInstance();

    private int dayOfMounth = calendar.get(Calendar.DAY_OF_MONTH);
    private int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    private int mounthOfJava = calendar.get(Calendar.MONTH);
    private int mounth = mounthOfJava + 1;

    private String idDay(){

        String dayOfWeekTxt = "";

        switch (dayOfWeek) {
            case 1:
                dayOfWeekTxt = "Domingo";
                break;
            case 2:
                dayOfWeekTxt = "Segunda";
                break;
            case 3:
                dayOfWeekTxt = "Terça";
                break;
            case 4:
                dayOfWeekTxt = "Quarta";
                break;
            case 5:
                dayOfWeekTxt = "Quinta";
                break;
            case 6:
                dayOfWeekTxt = "Sexta";
                break;
            case 7:
                dayOfWeekTxt = "Sábado";
                break;
        }
        return dayOfWeekTxt;
    }

    private String idMounth() {

        String mounthTxt = "";

        switch (mounth) {
            case 1:
                mounthTxt = "Janeiro";
                break;
            case 2:
                mounthTxt = "Fevereiro";
                break;
            case 3:
                mounthTxt = "Março";
                break;
            case 4:
                mounthTxt ="Abril";
                break;
            case 5:
                mounthTxt = "Maio";
                break;
            case 6:
                mounthTxt = "Junho";
                break;
            case 7:
                mounthTxt = "Julho";
                break;
            case 8:
                mounthTxt = "Agosto";
                break;
            case 9:
                mounthTxt = "Setembro";
                break;
            case 10:
                mounthTxt = "Outubro";
                break;
            case 11:
                mounthTxt = "Novembro";
                break;
            case 12:
                mounthTxt = "Dezembro";
                break;
        }
        return mounthTxt;
    }

    public String getDayOfMounth() {
        return String.valueOf(dayOfMounth);
    }

    public String getdayOfWeek() {
        return idDay();
    }

    public String getMounth() {
        return idMounth();
    }
}
