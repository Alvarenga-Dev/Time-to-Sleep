package com.llucasallvarenga.timetosleep.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.llucasallvarenga.timetosleep.R;

import java.util.ArrayList;

public class AdapterStopVibration extends RecyclerView.Adapter<AdapterStopVibration.ViewHolder> {

    private ArrayList<StopVibratingOptions> stopVibratingOptions; private OnItemClickListener listener;

    public interface OnItemClickListener{ void onItemClick(int position);}
    public void setOnClickListener(OnItemClickListener listener){ this.listener = listener; }

    public AdapterStopVibration(ArrayList<StopVibratingOptions> stopVibratingOptions) {
        this.stopVibratingOptions = stopVibratingOptions;
    }

    @NonNull
    @Override
    public AdapterStopVibration.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_options_stop_vibration, parent, false);
        return new ViewHolder(view, listener);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterStopVibration.ViewHolder holder, int position) {

        holder.tvStopVibration.setText(stopVibratingOptions.get(position).getStopVibratingOptions());

    }

    @Override
    public int getItemCount() {
        return stopVibratingOptions.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvStopVibration;

        ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            tvStopVibration = itemView.findViewById(R.id.tvDisplayStopVibrationId);

            itemView.setOnClickListener(view -> {

                if (listener != null){
                    int positionRcy = getAdapterPosition();
                    if (positionRcy != RecyclerView.NO_POSITION)
                        listener.onItemClick(positionRcy);
                }
            });

        }
    }
}