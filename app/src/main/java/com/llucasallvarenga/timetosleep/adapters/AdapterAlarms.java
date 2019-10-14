package com.llucasallvarenga.timetosleep.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.database.Alarm;

import java.text.MessageFormat;
import java.util.ArrayList;

public class AdapterAlarms extends RecyclerView.Adapter<AdapterAlarms.ViewHolder> {

    private ArrayList<Alarm> alarms;
    private OnItemClickListener listener;

    public interface OnItemClickListener{ void onItemClick(int position); }
    public void setOnItemClickListener(OnItemClickListener listener){ this.listener = listener; }

    public AdapterAlarms(ArrayList<Alarm> alarms) {
        this.alarms = alarms;
    }

    @NonNull
    @Override
    public AdapterAlarms.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_alarm, parent, false);

        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAlarms.ViewHolder holder, int position) {

        holder.hourAlarm.setText(MessageFormat.format("{0} : {1}", alarms.get(position).getHourDay(), alarms.get(position).getMiinuteDay()));

        if (position == ( getItemCount() - 1 ) ) holder.divAlarm.setBackgroundColor(Color.TRANSPARENT);

    }

    @Override
    public int getItemCount() {
        return alarms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView hourAlarm, divAlarm;
        Switch setAlarm;
        ConstraintLayout btnDelete;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            hourAlarm = itemView.findViewById(R.id.hourAlarmTvId);
            divAlarm = itemView.findViewById(R.id.divAlarmId);
            setAlarm = itemView.findViewById(R.id.setAlarmSwId);
            btnDelete = itemView.findViewById(R.id.btnDeleteAlarmId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int positionRcy = getAdapterPosition();
                            if (positionRcy != RecyclerView.NO_POSITION)
                                listener.onItemClick(positionRcy);
                    }
                }
            });

        }
    }
}
