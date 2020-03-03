package com.llucasallvarenga.timetosleep.view.fragments;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.view.activites.VTimerActivity;
import com.llucasallvarenga.timetosleep.view.adapters.AdapterAlarms;
import com.llucasallvarenga.timetosleep.database.Alarm;
import com.llucasallvarenga.timetosleep.database.DatabaseAlarmController;
import com.llucasallvarenga.timetosleep.utils.MyReceiver;
import com.llucasallvarenga.timetosleep.utils.Preferences;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class AlarmFragment extends Fragment {

    private DatabaseAlarmController controller;
    private AdapterAlarms adapter;
    private ArrayList<Alarm> alarmsFilters = new ArrayList<>();
    private Preferences preferences;

    public AlarmFragment() {  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_alarm, container, false);

        RecyclerView alarmListRcy = view.findViewById(R.id.alarmListRcyId);
        Button btnAddAlarm = view.findViewById(R.id.btnAddAlarmId);
        controller = new DatabaseAlarmController(Objects.requireNonNull(getActivity()).getBaseContext());
        preferences = new Preferences( getActivity() );

        btnAddAlarm.setOnClickListener(v -> {
           if (preferences.getConnection())
                setTimeFromTimePicker(getActivity(), v);
           else
                Snackbar.make(v, "Você precisa conectar com o HC-05", Snackbar.LENGTH_LONG)
                        .setAction("Conectar", vSnackbar ->{
                           Intent intent = new Intent(getActivity(), VTimerActivity.class);
                            startActivity(intent);
                      }).show();
        });

        onResume();

        alarmListRcy.setLayoutManager(new LinearLayoutManager( getActivity() ));
        alarmListRcy.setHasFixedSize(true);
        alarmListRcy.setNestedScrollingEnabled(false);
        adapter = new AdapterAlarms(alarmsFilters, getContext());
        alarmListRcy.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        if ( preferences.getFirstRun() ){
            ArrayList<Alarm> alarms = controller.read();
            alarmsFilters.addAll(alarms);
            preferences.saveFirstRun(false);
        }

    }

    private void setTimeFromTimePicker(Context context, View view) {

        int hourOfDay, minuteOfDay;

        Calendar timeOfDay = Calendar.getInstance();
        hourOfDay = timeOfDay.get(Calendar.HOUR_OF_DAY);
        minuteOfDay = timeOfDay.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                context,

                (timePicker, hourPicker, minutePicker) -> {

                 Calendar c = Calendar.getInstance();
                 c.set(Calendar.HOUR_OF_DAY, hourPicker);
                 c.set(Calendar.MINUTE, minutePicker);
                 c.set(Calendar.SECOND, 0);

                Alarm alarm = new Alarm();
                alarm.setHourDay(hourPicker);
                alarm.setMinuteDay(minutePicker);
                alarm.setOnAlarm(1);

                controller = new DatabaseAlarmController( Objects.requireNonNull(getActivity()).getBaseContext() );
                boolean success = controller.insert(alarm);

                if (success) {
                    Alarm alarmReturn = controller.readLastItem();
                    startAlarm(c);
                    adapter.addAlarm(alarmReturn);
                    Snackbar.make(view, "Alarme criado!", Snackbar.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(view, "Ops! Tente adicionar novamente.", Snackbar.LENGTH_SHORT).show();
                }

            },
                hourOfDay,
                minuteOfDay,
                android.text.format.DateFormat.is24HourFormat(getActivity())
        );

        timePickerDialog.show();
    }

    private void startAlarm(Calendar calendar) {
        AlarmManager alarmManager = (AlarmManager) Objects.requireNonNull(getActivity()).getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getActivity(), MyReceiver.class );
        PendingIntent pendingIntent = PendingIntent.getBroadcast( getActivity() , 1, intent, 0);

        if (calendar.before(Calendar.getInstance())) calendar.add(Calendar.DATE, 1);

        Objects.requireNonNull(alarmManager).setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }

}