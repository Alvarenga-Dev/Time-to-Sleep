package com.llucasallvarenga.timetosleep.view.introsreens;

import android.os.Bundle;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.llucasallvarenga.timetosleep.R;

public class TutorialsScreens extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setFullscreen(true);
        super.onCreate(savedInstanceState);

        addSlide(new FragmentSlide.Builder()
                .background(R.color.colorSlideImpar)
                .backgroundDark(R.color.colorBtnSlide)
                .fragment(new WelcomeSlide())
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(R.color.colorSlidePar)
                .backgroundDark(R.color.colorBtnSlide)
                .fragment(new AboutAppSlide())
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(R.color.colorSlideImpar)
                .backgroundDark(R.color.colorBtnSlide)
                .fragment(new BtEnableSlide())
                .build()
        );

    }
}
