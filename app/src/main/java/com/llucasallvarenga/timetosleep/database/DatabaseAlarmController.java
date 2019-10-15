package com.llucasallvarenga.timetosleep.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.llucasallvarenga.timetosleep.utils.Consts;

public class DatabaseAlarmController {

    private DatabaseAlarmInit databaseAlarmInit;
    private SQLiteDatabase sql;

    public DatabaseAlarmController(Context context) {
        databaseAlarmInit = new DatabaseAlarmInit(context);
        sql = databaseAlarmInit.getWritableDatabase();
    }

    public boolean insert(Alarm alarm) {

        ContentValues values = new ContentValues();

        values.put( Consts.HOUR_OF_DAY, alarm.getHourDay() );
        values.put( Consts.MINUTE_OF_DAY, alarm.getMiinuteDay() );

        return sql.insert(Consts.TABLE_NAME, null, values) > 0;

    }

}
