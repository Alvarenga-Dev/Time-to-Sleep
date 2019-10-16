package com.llucasallvarenga.timetosleep.fragments;

import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.adapters.AdapterAlarms;
import com.llucasallvarenga.timetosleep.database.Alarm;
import com.llucasallvarenga.timetosleep.database.DatabaseAlarmController;

import java.util.ArrayList;
import java.util.Calendar;

public class AlarmFragment extends Fragment {

    private DatabaseAlarmController controller;
    private RecyclerView alarmListRcy;
    private Button btnAddAlarm;
    private AdapterAlarms adapter;
    private ArrayList<Alarm> alarms;
    private ArrayList<Alarm> alarmsFilters = new ArrayList<>();

    public AlarmFragment() {  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_alarm, container, false);

        alarmListRcy = view.findViewById(R.id.alarmListRcyId);
        btnAddAlarm = view.findViewById(R.id.btnAddAlarmId);
        alarms = controller.read();
        alarmsFilters.addAll(alarms);

        btnAddAlarm.setOnClickListener(v -> setTimeFromTimePicker( getActivity(), v ));


        alarmListRcy.setLayoutManager(new LinearLayoutManager( getActivity() ));
        alarmListRcy.setHasFixedSize(true);
        alarmListRcy.setNestedScrollingEnabled(false);
        adapter = new AdapterAlarms(alarmsFilters, getContext());

        alarmListRcy.setAdapter(adapter);

        return view;
    }

    private void setTimeFromTimePicker(Context context, View view) {

        int hour, minute;

        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(context, (timePicker, hourOfDay, minuteOfDay) -> {

            Alarm alarm = new Alarm();
            alarm.setHourDay(hourOfDay);
            alarm.setMinuteDay(minuteOfDay);

            controller = new DatabaseAlarmController( getContext() );
            boolean success = controller.insert(alarm);

            if (success) {

                Alarm alarmReturn = controller.readLastItem();
                adapter.addAlarm(alarmReturn);
                Snackbar.make(view, "Salvou!", Snackbar.LENGTH_SHORT).show();
            }else{
                Snackbar.make(view, "Veja o LOG!", Snackbar.LENGTH_SHORT).show();
            }

        }, hour, minute, android.text.format.DateFormat.is24HourFormat(getActivity()) );

        timePickerDialog.show();
    }

}