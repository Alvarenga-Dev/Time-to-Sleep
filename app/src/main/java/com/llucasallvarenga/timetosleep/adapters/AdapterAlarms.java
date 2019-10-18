package com.llucasallvarenga.timetosleep.adapters;

import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.database.Alarm;
import com.llucasallvarenga.timetosleep.database.DatabaseAlarmController;
import com.llucasallvarenga.timetosleep.dialogs.AlertDialogAlarmDelete;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class AdapterAlarms extends RecyclerView.Adapter<AdapterAlarms.ViewHolder> {

    private ArrayList<Alarm> alarms;
    private Context context;
    private DatabaseAlarmController controller;

    public AdapterAlarms(){}

    public AdapterAlarms(ArrayList<Alarm> alarms, Context context) {
        this.alarms = alarms;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterAlarms.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_alarm, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAlarms.ViewHolder holder, final int position) {

        holder.hourAlarm.setText(MessageFormat.format("{0} : {1}", alarms.get(position).getHourDay(), alarms.get(position).getMinuteDay()));

        holder.hourAlarm.setOnClickListener(view -> setTimePicker(context, view, alarms.get(position), alarms.get(position).getId() ) );

        holder.btnDelete.setOnClickListener(view ->{
            AlertDialogAlarmDelete dialogAlarmDelete = new AlertDialogAlarmDelete( alarms.get(position) );
            FragmentManager manager = ((FragmentActivity)context).getSupportFragmentManager();
            dialogAlarmDelete.show( manager , "Alert Dialog para deletar os alarmes" );
        });

        if (position == ( getItemCount() - 1 ) ) holder.divContainer.setBackgroundColor(Color.TRANSPARENT);

    }

    public void addAlarm(Alarm alarm){
        alarms.add(alarm);
        notifyItemInserted( getItemCount() );
    }

    private void updateAlarm(Alarm alarm, Alarm alarmEdit){
        alarms.set( alarms.indexOf( alarm ) , alarmEdit );
        notifyItemChanged( alarms.indexOf(alarmEdit) ); //Joga os novos dados em tempo real...
    }

    public void deleteAlarm(Alarm alarm){
            int position = alarms.indexOf(alarm);
            alarms.remove(position);
            notifyItemRemoved(position);
    }

    private void setTimePicker(Context context, View view, Alarm alarm, int id){

        int hourOfDay, minuteOfDay;

        Calendar timeOfDay = Calendar.getInstance();
        hourOfDay = timeOfDay.get(Calendar.HOUR_OF_DAY);
        minuteOfDay = timeOfDay.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                context,
                ( timePicker, hourPicker, minutePicker) -> {

                    controller = new DatabaseAlarmController(context);
                    Alarm alarmEdit = new Alarm(id, hourPicker, minutePicker);
                    boolean success = controller.insert(alarmEdit);

                    if (success) {
                        updateAlarm(alarm, alarmEdit);
                        Snackbar.make(view, "Alarme Atualizado!", Snackbar.LENGTH_LONG).show();
                    }else
                        Snackbar.make(view, "Ops! Problema ao atualizar.", Snackbar.LENGTH_LONG).show();

                } ,
                    hourOfDay,
                    minuteOfDay,
                    android.text.format.DateFormat.is24HourFormat( context )
        );

        timePickerDialog.show();

    }

    @Override
    public int getItemCount() {
        return alarms.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView hourAlarm, divAlarm, divContainer;
        Switch setAlarm;
        ConstraintLayout btnDelete;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            hourAlarm = itemView.findViewById(R.id.hourAlarmTvId);
            divAlarm = itemView.findViewById(R.id.divAlarmId);
            divContainer = itemView.findViewById(R.id.divAlarmContainerId);
            setAlarm = itemView.findViewById(R.id.setAlarmSwId);
            btnDelete = itemView.findViewById(R.id.btnDeleteConfirmId);

        }

    }

    /*

    private void startAlarm(Calendar calendar) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, MyReceiver.class );
        PendingIntent pendingIntent = PendingIntent.getBroadcast( context , 1, intent, 0);

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }

    private void cancelAlarm(){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, MyReceiver.class );
        PendingIntent pendingIntent = PendingIntent.getBroadcast( context , 1, intent, 0);

        if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
            opa.setText("Alarm canceled!");
        }

    } */
}
