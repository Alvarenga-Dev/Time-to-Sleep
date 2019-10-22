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
        editor.putString(Consts.ALERTDIALOG_STOP_VIBRATION,value);
        editor.commit();
    }
    public void saveAlertDialogSleep(String value){
        editor.putString(Consts.ALERTDIALOG_SLEEP,value);
        editor.commit();
    }
    public void saveSeekBarProgress(int progress){
        editor.putInt(Consts.SEEKBAR_PROGRESS,progress);
        editor.commit();
    }

    public void saveSwicthIncrease(boolean increase){
        editor.putBoolean(Consts.SWICTH_INCREASE,increase);
        editor.commit();
    }

    public void saveFirstRun(boolean run){
        editor.putBoolean(Consts.FIRST_RUN,run);
        editor.commit();
    }

    public void saveOpenFirstApp(boolean open){
        editor.putBoolean(Consts.FIRST_OPEN, open);
        editor.commit();
    }

    public void saveConnection(boolean connection) {
        editor.putBoolean(Consts.CONNECTION_BT, connection );
        editor.commit();
    }

    public void saveMacAdressBt(String macAdress){
        editor.putString(Consts.MAC_ADDRESS_BT, macAdress);
        editor.commit();
    }

    public void saveNameDevice(String nameBt){
        editor.putString(Consts.NAME_BT, nameBt);
        editor.commit();
    }

    public void saveIntroScreens(boolean passedOn){
        editor.putBoolean(Consts.INTRO_SCREENS, passedOn);
        editor.commit();
    }

    //Métodos de recuperação de dados do sharedPreferences
    public String getAlertDialogStopVibration() { return preferences.getString(Consts.ALERTDIALOG_STOP_VIBRATION,"5 minutos"); }

    public String getAlertDialogSleep() { return preferences.getString(Consts.ALERTDIALOG_SLEEP,"10 minutos"); }

    public int getSeekBarProgress(){
        return preferences.getInt(Consts.SEEKBAR_PROGRESS, 0);
    }

    public boolean getSwicthIncrease() { return preferences.getBoolean(Consts.SWICTH_INCREASE, false); }

    public boolean getFirstRun() { return preferences.getBoolean(Consts.FIRST_RUN, true); }

    public Boolean getConnection() { return preferences.getBoolean(Consts.CONNECTION_BT, false); }

    public boolean getIntroScreens(){ return preferences.getBoolean(Consts.INTRO_SCREENS, false); }

    public boolean getFirstOpenApp(){ return preferences.getBoolean(Consts.FIRST_OPEN, true); }

    public String getMacAddress() { return preferences.getString(Consts.MAC_ADDRESS_BT, null); }

    public String getNameDevice() { return preferences.getString(Consts.NAME_BT, null); }
}
