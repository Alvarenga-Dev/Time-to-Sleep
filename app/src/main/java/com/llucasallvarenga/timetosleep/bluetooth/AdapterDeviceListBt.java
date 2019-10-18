package com.llucasallvarenga.timetosleep.bluetooth;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.llucasallvarenga.timetosleep.R;

import java.util.ArrayList;

public class AdapterDeviceListBt extends RecyclerView.Adapter<AdapterDeviceListBt.ViewHolder> {

    private ArrayList<Device> devices;
    private OnItemClickListener listener;

    public interface OnItemClickListener{ void onItemClick(int position); }
    public void setOnClickListener(OnItemClickListener listener){ this.listener = listener; }

    public AdapterDeviceListBt(ArrayList<Device> devices) {
        this.devices = devices;
    }

    @NonNull
    @Override
    public AdapterDeviceListBt.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_bt, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDeviceListBt.ViewHolder holder, int position) {
        holder.device.setText( devices.get(position).getNameBt() );

        if (position == ( getItemCount() - 1 ) ) holder.divItens.setBackgroundColor(Color.TRANSPARENT);

    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView device;
        TextView divItens;

        ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            device = itemView.findViewById(R.id.deviceTvId);
            divItens = itemView.findViewById(R.id.divItensListId);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int positionRcy = getAdapterPosition();
                        if (positionRcy != RecyclerView.NO_POSITION)
                            listener.onItemClick(positionRcy);
                }
            });

        }
    }
}
