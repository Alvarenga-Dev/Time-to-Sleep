package com.llucasallvarenga.timetosleep.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private static final String PREFERENCES = "ttp.preferences";
    private static final int MODE = 0;

    public Preferences(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCES, MODE);
        editor = preferences.edit();
    }

    //Métodos de salvamento de dados do sharedPreferences
    public void saveAlertDialogStopVibration(String value){
        editor.putString(Consts.ALERTDIALOGSTOPVIBRATION,value);
        editor.commit();
    }
    public void saveAlertDialogSleep(String value){
        editor.putString(Consts.ALERTDIALOGSLEEP,value);
        editor.commit();
    }
    public void saveSeekBarProgress(int progress){
        editor.putInt(Consts.SEEKBARPROGRESS,progress);
        editor.commit();
    }

    public void saveSwicthIncrease(boolean increase){
        editor.putBoolean(Consts.SWICTHINCREASE,increase);
        editor.commit();
    }

    public void saveFirstRun(boolean run){
        editor.putBoolean(Consts.FIRSTRUN,run);
        editor.commit();
    }

    public void saveOnAlarm(boolean onAlarm) {
        editor.putBoolean(Consts.ONALARM, onAlarm );
        editor.commit();
    }

    public void saveMacAdressBt(String macAdress){
        editor.putString(Consts.MACADDRESS, macAdress);
        editor.commit();
    }

    public void saveNameDevice(String nameBt){
        editor.putString(Consts.NAME_BT, nameBt);
        editor.commit();
    }

    public void saveIntroScreens(boolean passedOn){
        editor.putBoolean(Consts.INTROSCREENS, passedOn);
        editor.commit();
    }

    //Métodos de recuperação de dados do sharedPreferences
    public String getAlertDialogStopVibration() { return preferences.getString(Consts.ALERTDIALOGSTOPVIBRATION,"5 minutos"); }

    public String getAlertDialogSleep() { return preferences.getString(Consts.ALERTDIALOGSLEEP,"10 minutos"); }

    public int getSeekBarProgress(){
        return preferences.getInt(Consts.SEEKBARPROGRESS, 0);
    }

    public boolean getSwicthIncrease() { return preferences.getBoolean(Consts.SWICTHINCREASE, false); }

    public boolean getFirstRun() { return preferences.getBoolean(Consts.FIRSTRUN, true); }

    public boolean getOnAlarm() { return preferences.getBoolean(Consts.ONALARM, false); }

    public boolean getIntroScreens(){
        return preferences.getBoolean(Consts.INTROSCREENS, false);
    }

    public String getMacAddress() { return preferences.getString(Consts.MACADDRESS, "Nenhum Dispositivo Conectado"); }

    public String getNameDevice() { return preferences.getString(Consts.NAME_BT, "Nenhum Dispositivo Conectado"); }
}
