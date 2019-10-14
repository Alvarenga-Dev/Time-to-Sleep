package com.llucasallvarenga.timetosleep.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private static final String PREFERENCES = "ttp.preferences";
    private static final int MODE = 0;
    private static final String ALERTDIALOGSTOPVIBRATION = "tts.alertdialog.stopvibration";
    private static final String ALERTDIALOGSLEEP = "tts.alertdialog.sleep";
    private static final String SEEKBARPROGRESS = "tts.seekbar.progress";
    private static final String SWICTHINCREASE = "tts.swicth.increase";
    private static final String MACADRESS = "tts.mac.adress.bt";
    private static final String INTROSCREENS = "tts.intro.screens";

    public Preferences(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCES, MODE);
        editor = preferences.edit();
    }
    //Métodos de salvamento de dados do sharedPreferences
    public void saveAlertDialogStopVibration(String value){
        editor.putString(ALERTDIALOGSTOPVIBRATION,value);
        editor.commit();
    }
    public void saveAlertDialogSleep(String value){
        editor.putString(ALERTDIALOGSLEEP,value);
        editor.commit();
    }
    public void saveSeekBarProgress(int progress){
        editor.putInt(SEEKBARPROGRESS,progress);
        editor.commit();
    }

    public void saveSwicthIncrease(boolean increase){
        editor.putBoolean(SWICTHINCREASE,increase);
        editor.commit();
    }

    public void saveMacAdressBt(String macAdress){
        editor.putString(MACADRESS, macAdress);
        editor.commit();
    }

    public void saveIntroScreens(boolean passedOn){
        editor.putBoolean(INTROSCREENS, passedOn);
        editor.commit();
    }
    //Métodos de recuperação de dados do sharedPreferences
    public String getAlertDialogStopVibration(){ return preferences.getString(ALERTDIALOGSTOPVIBRATION,"5 minutos"); }

    public String getAlertDialogSleep(){ return preferences.getString(ALERTDIALOGSLEEP,"10 minutos"); }

    public int getSeekBarProgress(){
        return preferences.getInt(SEEKBARPROGRESS, 0);
    }

    public boolean getSwicthIncrease(){
        return preferences.getBoolean(SWICTHINCREASE, false);
    }

    public String getMacadress() { return preferences.getString(MACADRESS, "Nenhum Dispositivo Conectado"); }

    public boolean getIntroScreens(){
        return preferences.getBoolean(INTROSCREENS, false);
    }
}
