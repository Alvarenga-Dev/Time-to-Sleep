package com.llucasallvarenga.timetosleep.fragments;

import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.adapters.AdapterAlarms;
import com.llucasallvarenga.timetosleep.database.Alarm;
import com.llucasallvarenga.timetosleep.database.DatabaseAlarmController;
import com.llucasallvarenga.timetosleep.dialogs.TimePickerFragment;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class AlarmFragment extends Fragment {

    private DatabaseAlarmController controller;
    private RecyclerView alarmListRcy;
    private Button btnAddAlarm;
    private ArrayList<Alarm> alarms;
    private ArrayList<Alarm> alarmsFilters = new ArrayList<>();

    public AlarmFragment() {  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_alarm, container, false);

        alarmListRcy = view.findViewById(R.id.alarmListRcyId);
        btnAddAlarm = view.findViewById(R.id.btnAddAlarmId);
        alarms = new ArrayList<>();

        btnAddAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTimeFromTimePicker(getActivity());
            }
        });


        alarmListRcy.setLayoutManager(new LinearLayoutManager( getActivity() ));
        alarmListRcy.setHasFixedSize(true);
        alarmListRcy.setNestedScrollingEnabled(false);
        AdapterAlarms adapter = new AdapterAlarms(alarms);

        alarmListRcy.setAdapter(adapter);

        return view;
    }

    private void setTimeFromTimePicker(Context context) {

        int hourOfDay, minute;

        final Calendar c = Calendar.getInstance();
        hourOfDay = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        TimePickerDialog dpd = new TimePickerDialog(context, (timePicker, hourOfDay1, minute1) -> {
            String a = String.valueOf(hourOfDay1);
            Log.i("OPAAA", a);

        }, hourOfDay, minute, false);

        String a = String.valueOf(hourOfDay);
        Log.i("OPAAA", a);

        dpd.show();
    }
}