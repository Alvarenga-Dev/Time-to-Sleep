package com.llucasallvarenga.timetosleep.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.llucasallvarenga.timetosleep.utils.Consts;

public class DatabaseAlarmInit extends SQLiteOpenHelper {

    private static final String DATABSE_NAME = "database.db";
    private static final int VERSION = 1;

    public DatabaseAlarmInit(@Nullable Context context) {
        super(context, DATABSE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + Consts.TABLE_NAME +"(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Consts.HOUR_OF_DAY + " INTEGER, "+ Consts.MINUTE_OF_DAY +" INTEGER, " + Consts.ALARM_ON + " INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

}
