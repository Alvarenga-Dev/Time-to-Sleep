package com.llucasallvarenga.timetosleep.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.adapters.AdapterAlarms;
import com.llucasallvarenga.timetosleep.database.Alarm;
import com.llucasallvarenga.timetosleep.database.DatabaseAlarmController;

import java.util.ArrayList;

public class AlarmFragment extends Fragment {

    private DatabaseAlarmController controller;
    private RecyclerView alarmListRcy;
    private ArrayList<Alarm> alarms;
    private ArrayList<Alarm> alarmsFilters = new ArrayList<>();

    private int hour[] = {
            12,
            13,
            5,
            7
    };

    private int minute[] = {
            30,
            45,
            20,
            25
    };

    public AlarmFragment() {  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_alarm, container, false);

        alarmListRcy = view.findViewById(R.id.alarmListRcyId);
        alarms = new ArrayList<>();

        alarmListRcy.setLayoutManager(new LinearLayoutManager( getActivity() ));
        AdapterAlarms adapter = new AdapterAlarms(alarms);
        opa();
        alarmListRcy.setAdapter(adapter);

        return view;
    }

    private void opa(){
        for (int i = 0; i < hour.length; i++)
            alarms.add( new Alarm(0,hour[i], minute[i]) );
    }
}