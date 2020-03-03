package com.llucasallvarenga.timetosleep.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.view.fragments.VTimerListBtFragment;
import com.llucasallvarenga.timetosleep.view.fragments.VTimerStatusFragment;
import com.llucasallvarenga.timetosleep.utils.Preferences;

public class VTimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vtimer);

        Preferences preferences = new Preferences(VTimerActivity.this);

        if (savedInstanceState == null) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            if (preferences.getConnection())
                transaction.add(R.id.containerVTimerId, new VTimerStatusFragment()).commit();
            else
                transaction.add(R.id.containerVTimerId, new VTimerListBtFragment()).commit();

        }
    }
}
