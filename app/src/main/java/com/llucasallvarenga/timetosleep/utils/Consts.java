package com.llucasallvarenga.timetosleep.utils;

import java.util.UUID;

public class Consts {

    // for Database
    public static final String TABLE_NAME = "AlarmsDatabase";
    public static final String ID = "id";
    public static final String HOUR_OF_DAY = "hour";
    public static final String MINUTE_OF_DAY = "minute";
    public static final String ALARM_ON = "alarmOn";

    // for Preferences
    public static final String ALERTDIALOG_STOP_VIBRATION = "tts.alertdialog.stopvibration";
    public static final String ALERTDIALOG_SLEEP = "tts.alertdialog.sleep";
    public static final String SEEKBAR_PROGRESS = "tts.seekbar.progress";
    public static final String SWICTH_INCREASE = "tts.swicth.increase";
    public static final String INTRO_SCREENS = "tts.intro.screens";
    public static final String FIRST_RUN = "tts.first.run";

    // for notification
    public static final String CHANNEL1ID = "channel1ID";
    public static final String CHANNEL1Name = "channel 1";

    // for Bluetooth
    public static final int REQUEST_ENABLE_BT = 1;
    public static final int REQUEST_CONNECTION_BT = 2;
    public static final int MESSAGE_READ = 3;
    public static final String MAC_ADDRESS_BT = "tts.mac.adress.bt";
    public static final String NAME_BT = "tts.name.bt";
    public static final String CONNECTION_BT = "tts.connection.bt";
    public static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

    //for MyServices
    public static final String ROUTER = "tts.string.router";
}
