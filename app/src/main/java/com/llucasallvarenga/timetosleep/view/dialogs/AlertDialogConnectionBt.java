package com.llucasallvarenga.timetosleep.view.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.utils.MyServices;

public class AlertDialogConnectionBt extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.alert_dialog_connection_bt, null);
        builder.setView(view);
        builder.setCancelable(false);

        final AlertDialog dialog = builder.create();

        Handler handler = new Handler();

        handler.postDelayed(() -> {
            Intent intent = new Intent(getActivity(), MyServices.class);
            getActivity().startService(intent);
            getActivity().finish();

        }, 1200);

        dialog.getWindow().setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));

        return dialog;

    }
}
