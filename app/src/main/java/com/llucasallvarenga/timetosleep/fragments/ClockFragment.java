package com.llucasallvarenga.timetosleep.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.utils.Data;

public class ClockFragment extends Fragment {

    private TextView date;

    public ClockFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_clock, container, false);

        date = view.findViewById(R.id.dateId);

        Data dateTxt = new Data();

        String dayOfWeek = dateTxt.getdayOfWeek();
        String dayOfMounth = dateTxt.getDayOfMounth();
        String mounth = dateTxt.getMounth();

        date.setText( String.format("%s, %s de %s", dayOfWeek, dayOfMounth, mounth) );

        return view;
    }
}