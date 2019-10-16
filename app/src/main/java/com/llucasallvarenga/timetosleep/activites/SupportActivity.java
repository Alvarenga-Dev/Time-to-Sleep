package com.llucasallvarenga.timetosleep.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.llucasallvarenga.timetosleep.R;

public class SupportActivity extends AppCompatActivity {

    private ImageView btnReturn;
    private Button btnSend;
    private ConstraintLayout supportLayout;
    private TextInputLayout inputMail;
    private TextInputLayout inputDescriptionProblem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        btnReturn = findViewById(R.id.btnBackSettingsId);
        btnSend = findViewById(R.id.btnSendId);
        supportLayout = findViewById(R.id.supportLayoutId);
        inputMail = findViewById(R.id.inputMailId);
        inputDescriptionProblem = findViewById(R.id.inputDescriptionProblemId);

        btnReturn.setOnClickListener(v -> finish());


        btnSend.setOnClickListener(v -> verificationInput());

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    private void verificationInput() {

        String mailValue = inputMail.getEditText().getText().toString();
        String descriptionProblemValue = inputDescriptionProblem.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (mailValue.isEmpty()) {
            Snackbar snackbar = Snackbar.make(supportLayout, "Campo vazio!", Snackbar.LENGTH_SHORT);
            snackbar.show();
        }

    }
}
