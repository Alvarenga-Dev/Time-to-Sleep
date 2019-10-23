package com.llucasallvarenga.timetosleep.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import com.llucasallvarenga.timetosleep.R;

public class AppDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_data);

        Button btnLicense = findViewById(R.id.btnLicenseId);

        btnLicense.setOnClickListener(View ->{
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://timetosleepbr.github.io/license.html"));
            startActivity(intent);
        });

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
