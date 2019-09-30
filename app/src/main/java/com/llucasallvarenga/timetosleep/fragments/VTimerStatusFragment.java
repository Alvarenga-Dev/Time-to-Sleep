package com.llucasallvarenga.timetosleep.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.llucasallvarenga.timetosleep.HomeActivity;
import com.llucasallvarenga.timetosleep.R;

public class VTimerStatusFragment extends Fragment {

    private ImageView btnBackSettings;

    public VTimerStatusFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vtimer_status, container, false);

        btnBackSettings = view.findViewById(R.id.btnBackSettingsId);

        btnBackSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return view;
    }

}
