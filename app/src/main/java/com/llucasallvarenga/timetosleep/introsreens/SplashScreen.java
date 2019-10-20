package com.llucasallvarenga.timetosleep.introsreens;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.llucasallvarenga.timetosleep.HomeActivity;
import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.utils.MyServices;
import com.llucasallvarenga.timetosleep.utils.Preferences;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Preferences preferences = new Preferences(SplashScreen.this);

        ImageView logo = findViewById(R.id.ivLogoSplashScreenId);
        logo.setBackgroundResource(R.drawable.anim_logo_tts);
        AnimationDrawable animationDrawable = (AnimationDrawable) logo.getBackground();
        animationDrawable.start();

        Handler handler = new Handler();
        handler.postDelayed(() -> {

            if (preferences.getConnection() && BluetoothAdapter.getDefaultAdapter().isEnabled()) {
                Intent intent = new Intent(SplashScreen.this, MyServices.class);
                startService(intent);
            }

            router();

        }, 4500);

    }

    private void router(){
        Intent intent = new Intent(SplashScreen.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
