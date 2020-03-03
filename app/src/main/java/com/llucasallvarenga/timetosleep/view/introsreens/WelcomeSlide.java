package com.llucasallvarenga.timetosleep.view.introsreens;

import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heinrichreimersoftware.materialintro.app.SlideFragment;
import com.llucasallvarenga.timetosleep.R;

public class WelcomeSlide extends SlideFragment {

    public WelcomeSlide() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.slide_welcome, container, false);
    }

}
