package com.llucasallvarenga.timetosleep.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.fragments.VTimerListBtFragment;
import com.llucasallvarenga.timetosleep.fragments.VTimerStatusFragment;

public class VTimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vtimer);

        if (savedInstanceState == null) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.containerVTimerId, new VTimerListBtFragment()).commit();
        }
    }
}
