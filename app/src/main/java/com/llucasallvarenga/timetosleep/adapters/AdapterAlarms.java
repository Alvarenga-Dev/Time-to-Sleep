package com.llucasallvarenga.timetosleep.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.database.Alarm;

import java.text.MessageFormat;
import java.util.ArrayList;

public class AdapterAlarms extends RecyclerView.Adapter<AdapterAlarms.ViewHolder> {

    private ArrayList<Alarm> alarms;
    private Context context;

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
    public void onBindViewHolder(@NonNull AdapterAlarms.ViewHolder holder, int position) {

        holder.hourAlarm.setText(MessageFormat.format("{0} : {1}", alarms.get(position).getHourDay(), alarms.get(position).getMinuteDay()));

        holder.hourAlarm.setOnClickListener(view -> Toast.makeText( context , "", Toast.LENGTH_SHORT).show());

        if (position == ( getItemCount() - 1 ) ) holder.divContainer.setBackgroundColor(Color.TRANSPARENT);

    }

    public void addAlarm(Alarm alarm){
        alarms.add(alarm);
        notifyItemInserted( getItemCount() );
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
            btnDelete = itemView.findViewById(R.id.btnDeleteAlarmId);


        }
    }

    /*

    private  void startAlarm(Calendar calendar) {
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
