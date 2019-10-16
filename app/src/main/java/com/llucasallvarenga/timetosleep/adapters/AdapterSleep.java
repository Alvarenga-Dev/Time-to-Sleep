package com.llucasallvarenga.timetosleep.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.llucasallvarenga.timetosleep.R;

import java.util.ArrayList;

public class AdapterSleep extends RecyclerView.Adapter<AdapterSleep.ViewHolder> {

    private ArrayList<SleepOptions> sleepOptions;
    private OnItemClickListener listener;

    public interface OnItemClickListener{ void onItemClick(int position);}
    public void setOnClickListener(OnItemClickListener listener){ this.listener = listener; }

    public AdapterSleep(ArrayList<SleepOptions> sleepOptions) {
        this.sleepOptions = sleepOptions;
    }

    @NonNull
    @Override
    public AdapterSleep.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_options_sleep, parent,false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSleep.ViewHolder holder, int position) {
        holder.tvSleep.setText( sleepOptions.get(position).getMinutes() );
    }

    @Override
    public int getItemCount() {
        return sleepOptions.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvSleep;

        ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            tvSleep = itemView.findViewById(R.id.tvDisplayOptionsSleepEId);

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
