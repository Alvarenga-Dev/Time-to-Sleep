package com.llucasallvarenga.timetosleep.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.llucasallvarenga.timetosleep.HomeActivity;
import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.dialogs.AlertDialogSleep;
import com.llucasallvarenga.timetosleep.dialogs.AlertDialogStopVibration;
import com.llucasallvarenga.timetosleep.utils.Preferences;

public class SettingsActivity extends AppCompatActivity implements AlertDialogStopVibration.AlertDialogListener, AlertDialogSleep.AlertDialogListener  {

    private ImageView btnReturn;
    private SeekBar vibrationLevel;
    private ConstraintLayout conteinerSleep;
    private ConstraintLayout conteinerVibrationStop;
    private TextView vibrationsMinutes;
    private TextView sleepMinutes;
    private TextView levelOne;
    private TextView levelTwo;
    private TextView leveThree;
    private Switch allowIncreaseVibration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnReturn = findViewById(R.id.btnBackSettingsId);
        vibrationLevel = findViewById(R.id.progressVibrationId);
        conteinerSleep = findViewById(R.id.btnSleepId);
        conteinerVibrationStop = findViewById(R.id.btnStopVibrationId);
        vibrationsMinutes = findViewById(R.id.tvValueInitStopVibrationId);
        sleepMinutes = findViewById(R.id.valueInitSleepId);
        levelOne = findViewById(R.id.levelOneId);
        levelTwo = findViewById(R.id.levelTwoId);
        leveThree = findViewById(R.id.levelThreeId);
        allowIncreaseVibration = findViewById(R.id.increaseId);
        final Preferences preferences = new Preferences(SettingsActivity.this);

        //btn return
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //values - Stop vibration
        conteinerVibrationStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialogStopVibration alertDialogStopVibration = new AlertDialogStopVibration();
                alertDialogStopVibration.show(getSupportFragmentManager(), "AlertDialog para opcões para quando parar de vibrar o V-timer.");
            }
        });
        vibrationsMinutes.setText( preferences.getAlertDialogStopVibration() );
        //Valores - Soneca
        conteinerSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialogSleep alertDialogSleep = new AlertDialogSleep();
                alertDialogSleep.show(getSupportFragmentManager(), "AlertDialog para opcões do modo soneca do V-timer.");
            }
        });
        sleepMinutes.setText( preferences.getAlertDialogSleep() );
        //seekBar
        final int progressVibrationLevel = preferences.getSeekBarProgress();
        vibrationLevel.setMax(2);
        vibrationLevel.setProgress(progressVibrationLevel);
        vibrationLevelIndication(progressVibrationLevel);
        vibrationLevel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vibrationLevelIndication(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                preferences.saveSeekBarProgress(seekBar.getProgress());
            }
        });
        //Swicth aumentar vibração
        allowIncreaseVibration.setChecked(preferences.getSwicthIncrease());
        allowIncreaseVibration.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    preferences.saveSwicthIncrease(true);
                }else{
                    preferences.saveSwicthIncrease(false);
                }
            }
        });
    }

    private void vibrationLevelIndication(int progress){
        String colorUnselection = "#FFFFFF";
        String colorSelection = "#54D0DD";
        if (progress == 0){
            levelOne.setTextColor(Color.parseColor(colorSelection));
            levelTwo.setTextColor(Color.parseColor(colorUnselection));
            leveThree.setTextColor(Color.parseColor(colorUnselection));
        }else if (progress == 1){
            levelOne.setTextColor(Color.parseColor(colorUnselection));
            levelTwo.setTextColor(Color.parseColor(colorSelection));
            leveThree.setTextColor(Color.parseColor(colorUnselection));
        }else if (progress == 2){
            levelOne.setTextColor(Color.parseColor(colorUnselection));
            levelTwo.setTextColor(Color.parseColor(colorUnselection));
            leveThree.setTextColor(Color.parseColor(colorSelection));
        }

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    private void rota(){
        Intent intent = new Intent(SettingsActivity.this, HomeActivity.class);
        startActivity( intent );
    }

    @Override
    public void minutesStopVibration(String valueStopVibration) {
        vibrationsMinutes.setText(valueStopVibration);
        Preferences preferencias = new Preferences(SettingsActivity.this);
        preferencias.saveAlertDialogStopVibration(valueStopVibration);
    }

    @Override
    public void minutesSleep(String valueSleep) {
        sleepMinutes.setText(valueSleep);
        Preferences preferencias = new Preferences(SettingsActivity.this);
        preferencias.saveAlertDialogSleep(valueSleep);
    }
}