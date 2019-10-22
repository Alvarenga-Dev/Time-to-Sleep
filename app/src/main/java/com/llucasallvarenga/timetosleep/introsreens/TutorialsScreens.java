package com.llucasallvarenga.timetosleep.introsreens;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.app.SlideFragment;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;
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
