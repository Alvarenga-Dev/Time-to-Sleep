package com.llucasallvarenga.timetosleep.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.llucasallvarenga.timetosleep.HomeActivity;
import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.utils.ConnectedThread;
import com.llucasallvarenga.timetosleep.utils.Consts;
import com.llucasallvarenga.timetosleep.utils.MyServices;
import com.llucasallvarenga.timetosleep.utils.Preferences;

import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

public class AlarmStopActivity extends AppCompatActivity {

    private Button btnAlarmStop;
    private TextView tvAlarmValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_stop);

        btnAlarmStop = findViewById(R.id.btnAlarmStopId);
        tvAlarmValue = findViewById(R.id.tvValueAlarmId);


        btnAlarmStop.setOnClickListener(View ->{
            Intent intent = new Intent(AlarmStopActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });

    }
}
