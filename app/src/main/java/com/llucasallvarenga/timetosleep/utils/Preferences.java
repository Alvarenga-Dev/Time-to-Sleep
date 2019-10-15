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

    public void saveMacAdressBt(String macAdress){
        editor.putString(Consts.MACADRESS, macAdress);
        editor.commit();
    }

    public void saveIntroScreens(boolean passedOn){
        editor.putBoolean(Consts.INTROSCREENS, passedOn);
        editor.commit();
    }
    //Métodos de recuperação de dados do sharedPreferences
    public String getAlertDialogStopVibration(){ return preferences.getString(Consts.ALERTDIALOGSTOPVIBRATION,"5 minutos"); }

    public String getAlertDialogSleep(){ return preferences.getString(Consts.ALERTDIALOGSLEEP,"10 minutos"); }

    public int getSeekBarProgress(){
        return preferences.getInt(Consts.SEEKBARPROGRESS, 0);
    }

    public boolean getSwicthIncrease(){
        return preferences.getBoolean(Consts.SWICTHINCREASE, false);
    }

    public String getMacadress() { return preferences.getString(Consts.MACADRESS, "Nenhum Dispositivo Conectado"); }

    public boolean getIntroScreens(){
        return preferences.getBoolean(Consts.INTROSCREENS, false);
    }
}
