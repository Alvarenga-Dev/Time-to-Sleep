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
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.adapters.AdapterAlarms;
import com.llucasallvarenga.timetosleep.database.Alarm;
import com.llucasallvarenga.timetosleep.database.DatabaseAlarmController;
import com.llucasallvarenga.timetosleep.utils.Preferences;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class AlarmFragment extends Fragment {

    private DatabaseAlarmController controller;
    private RecyclerView alarmListRcy;
    private Button btnAddAlarm;
    private AdapterAlarms adapter;
    private ArrayList<Alarm> alarms;
    private ArrayList<Alarm> alarmsFilters = new ArrayList<>();
    private Preferences preferences;

    public AlarmFragment() {  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_alarm, container, false);

        alarmListRcy = view.findViewById(R.id.alarmListRcyId);
        btnAddAlarm = view.findViewById(R.id.btnAddAlarmId);
        controller = new DatabaseAlarmController(Objects.requireNonNull(getActivity()).getBaseContext());
        preferences = new Preferences( getActivity() );

        btnAddAlarm.setOnClickListener(v -> setTimeFromTimePicker( getActivity(), v ));

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
            alarms = controller.read();
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

                Alarm alarm = new Alarm();
                alarm.setHourDay(hourPicker);
                alarm.setMinuteDay(minutePicker);

                controller = new DatabaseAlarmController( Objects.requireNonNull(getActivity()).getBaseContext() );
                boolean success = controller.insert(alarm);

                if (success) {
                    Alarm alarmReturn = controller.readLastItem();
                    preferences.saveOnAlarm(true);
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

}