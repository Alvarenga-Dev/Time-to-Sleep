package com.llucasallvarenga.timetosleep.view.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.llucasallvarenga.timetosleep.R;

public class ChronometerFragment extends Fragment {

    private Chronometer chronometer;
    private Button btnChronometer;
    private TextView btnReset;
    private TextView tvDescriptionChronometer;
    private long pauseOff;
    private boolean chronometerStarted;

    public ChronometerFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chronometer, container, false);

        chronometer = view.findViewById(R.id.chronometerValueId);
        btnChronometer = view.findViewById(R.id.btnChronometerId);
        btnReset = view.findViewById(R.id.btnResetId);
        tvDescriptionChronometer = view.findViewById(R.id.tvDescriptionChronometerId);

        btnChronometer.setOnClickListener(v -> cronometro());

        return view;
    }

    private void cronometro(){

        if (!chronometerStarted) {
            btnChronometer.setText(R.string.btn_title_pausar_crono);
            btnReset.setVisibility(View.INVISIBLE);
            tvDescriptionChronometer.setVisibility(View.INVISIBLE);
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOff);
            chronometer.start();
            chronometerStarted = true;
        } else {
            btnReset.setVisibility(View.VISIBLE);
            btnChronometer.setText(R.string.btn_title_retornar_crono);
            chronometer.stop();
            pauseOff = SystemClock.elapsedRealtime() - chronometer.getBase();
            chronometerStarted = false;

            btnReset.setOnClickListener(v -> {
                chronometer.setBase(SystemClock.elapsedRealtime());
                pauseOff = 0;
                btnChronometer.setText(R.string.btn_title_iniciar_crono);
                btnReset.setVisibility(View.INVISIBLE);
                tvDescriptionChronometer.setVisibility(View.VISIBLE);
            });
        }
    }
}