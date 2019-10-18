package com.llucasallvarenga.timetosleep.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.llucasallvarenga.timetosleep.utils.Consts;

import java.util.ArrayList;

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
        values.put( Consts.MINUTE_OF_DAY, alarm.getMinuteDay() );

        if ( alarm.getId() > 0 )
            return sql.update(Consts.TABLE_NAME, values, "id = ?", new String[]{ alarm.getId() + "" }) > 0;
        else
            return sql.insert(Consts.TABLE_NAME, null, values) > 0;

    }

    public ArrayList<Alarm> read() {
        ArrayList<Alarm> alarms = new ArrayList<>();

        Cursor cursor = sql.rawQuery(
                "SELECT " +
                        Consts.ID + "," +
                        Consts.HOUR_OF_DAY  +  "," +
                        Consts.MINUTE_OF_DAY + " FROM "+
                        Consts.TABLE_NAME ,
                null);

        int indexColumnId = cursor.getColumnIndex(Consts.ID);
        int indexColumnHourOfDay = cursor.getColumnIndex(Consts.HOUR_OF_DAY);
        int indexColumnMinuteOfDay = cursor.getColumnIndex(Consts.MINUTE_OF_DAY);

        while( cursor.moveToNext() ) {
            Alarm alarm = new Alarm();
            alarm.setId(cursor.getInt(indexColumnId));
            alarm.setHourDay(cursor.getInt(indexColumnHourOfDay));
            alarm.setMinuteDay(cursor.getInt(indexColumnMinuteOfDay));
            alarms.add(alarm);
        }

        cursor.close();

        return alarms;

    }

    public Alarm readLastItem() {

        Cursor cursor = sql.rawQuery("SELECT * FROM " + Consts.TABLE_NAME + " ORDER BY ID DESC", null);

        int indexColumnId = cursor.getColumnIndex(Consts.ID);
        int indexColumnHourOfDay = cursor.getColumnIndex(Consts.HOUR_OF_DAY);
        int indexColumnMinuteOfDay = cursor.getColumnIndex(Consts.MINUTE_OF_DAY);

        if ( cursor.moveToFirst() ) {
            int id = cursor.getInt(indexColumnId);
            int hour = cursor.getInt(indexColumnHourOfDay);
            int minute = cursor.getInt(indexColumnMinuteOfDay);
            cursor.close();
            return new Alarm(id, hour, minute);
        }

        return null;

    }

    public boolean delete(int id){
        return sql.delete(Consts.TABLE_NAME, "id = ?", new String[]{id + ""}) > 0;
    }

}
