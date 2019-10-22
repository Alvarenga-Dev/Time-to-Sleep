package com.llucasallvarenga.timetosleep.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import com.llucasallvarenga.timetosleep.HomeActivity;
import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.utils.Consts;
import com.llucasallvarenga.timetosleep.utils.MyServices;

public class AlarmStopActivity extends AppCompatActivity {

    private Button btnAlarmStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_stop);

        btnAlarmStop = findViewById(R.id.btnAlarmStopId);

        Intent intentService = new Intent(AlarmStopActivity.this, MyServices.class);
        intentService.putExtra(Consts.ROUTER, "setAlarm");
        startService(intentService);

        btnAlarmStop.setOnClickListener(View ->{
            Intent intent = new Intent(AlarmStopActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });

    }
}
