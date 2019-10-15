package com.llucasallvarenga.timetosleep.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.llucasallvarenga.timetosleep.utils.Consts;

public class DatabaseAlarmInit extends SQLiteOpenHelper {


    public DatabaseAlarmInit(@Nullable Context context) {
        super(context, Consts.DATABSE_NAME, null, Consts.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS " + Consts.TABLE_NAME + " (" + Consts.ID + " int primary key autoincrement, " +
                        Consts.HOUR_OF_DAY + " int(2), " + Consts.MINUTE_OF_DAY + " int(2)" + ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

}
