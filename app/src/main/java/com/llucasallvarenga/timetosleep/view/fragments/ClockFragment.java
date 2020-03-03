package com.llucasallvarenga.timetosleep.view.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;

import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.utils.Clock;
import com.llucasallvarenga.timetosleep.utils.Data;

import rm.com.clocks.ClockImageView;

public class ClockFragment extends Fragment {

    private TextView date;
    private ClockImageView ivClock;
    private TextClock tvClock;

    public ClockFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_clock, container, false);

        ivClock = view.findViewById(R.id.ivClockId);
        tvClock = view.findViewById(R.id.tvClockId);
        date = view.findViewById(R.id.dateId);

        Data dateTxt = new Data();
        Clock clock = new Clock();

        String dayOfWeek = dateTxt.getdayOfWeek();
        String dayOfMounth = dateTxt.getDayOfMounth();
        String mounth = dateTxt.getMounth();

        date.setText( String.format("%s, %s de %s", dayOfWeek, dayOfMounth, mounth) );
        ivClock.animateToTime( Integer.parseInt( clock.getAlarmHour() ), Integer.parseInt( clock.getAlarmMinutes() ) );

        return view;
    }
}