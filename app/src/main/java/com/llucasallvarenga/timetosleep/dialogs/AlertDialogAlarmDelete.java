package com.llucasallvarenga.timetosleep.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;

import com.llucasallvarenga.timetosleep.R;

public class AlertDialogAlarmDelete extends AppCompatDialogFragment {

    public Button btnDeleteConfirm;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.alert_dialog_alarm_delete, null);
        builder.setView(view);

        btnDeleteConfirm = view.findViewById(R.id.btnDeleteAlarmId);

        final AlertDialog dialog = builder.create();

        dialog.getWindow().setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));

        dialog.show();
        return dialog;

    }
}
