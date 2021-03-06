package com.llucasallvarenga.timetosleep.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.llucasallvarenga.timetosleep.view.activites.AlarmStopActivity;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent i = new Intent(context.getApplicationContext(), AlarmStopActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

    }
}
