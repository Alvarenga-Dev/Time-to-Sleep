package com.llucasallvarenga.timetosleep.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.llucasallvarenga.timetosleep.R;

public class AlarmFragment extends Fragment {

    public AlarmFragment() {  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_alarm, container, false);

        return view;
    }
}