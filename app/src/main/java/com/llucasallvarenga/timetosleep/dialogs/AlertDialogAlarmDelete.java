package com.llucasallvarenga.timetosleep.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.adapters.AdapterAlarms;
import com.llucasallvarenga.timetosleep.database.Alarm;
import com.llucasallvarenga.timetosleep.database.DatabaseAlarmController;

import java.util.ArrayList;
import java.util.Objects;

public class AlertDialogAlarmDelete extends AppCompatDialogFragment {

    private TextView btnDeleteConfirm;
    private AdapterAlarms adapterAlarms;
    private DatabaseAlarmController controller;

    private Alarm alarm;
    private ArrayList<Alarm> alarms;

    public AlertDialogAlarmDelete( Alarm alarm, ArrayList<Alarm> alarms ){
        this.alarm = alarm;
        this.alarms = alarms;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.alert_dialog_alarm_delete, null);
        builder.setView(view);

        final AlertDialog dialog = builder.create();

        btnDeleteConfirm = view.findViewById(R.id.btnDeleteConfirmId);
        adapterAlarms = new AdapterAlarms( getAlarms() );
        controller = new DatabaseAlarmController( getContext() );

        btnDeleteConfirm.setOnClickListener( View -> {

            boolean success = controller.delete( getAlarm().getId() );

            if (success) {
                adapterAlarms.deleteAlarm(getAlarm());
                dialog.dismiss();
            } else {
                dialog.dismiss();
            }

        } );

        dialog.getWindow().setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));

        return dialog;

    }

    private Alarm getAlarm() {
        return alarm;
    }

    public ArrayList<Alarm> getAlarms() {
        return alarms;
    }
}
