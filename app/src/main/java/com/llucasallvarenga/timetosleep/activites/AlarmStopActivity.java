package com.llucasallvarenga.timetosleep.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.llucasallvarenga.timetosleep.HomeActivity;
import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.utils.Consts;

import java.util.Calendar;

public class AlarmStopActivity extends AppCompatActivity {

    private Button btnAlarmStop;
    private TextView tvAlarmValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_stop);

        btnAlarmStop = findViewById(R.id.btnAlarmStopId);
        tvAlarmValue = findViewById(R.id.tvValueAlarmId);

        Calendar calendar = Calendar.getInstance();

        tvAlarmValue.setText( String.format( "%2d:%2d", calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE) ) );

        btnAlarmStop.setOnClickListener(View ->{
            Intent intent = new Intent(AlarmStopActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });

    }
}
