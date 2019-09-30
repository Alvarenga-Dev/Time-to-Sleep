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
    private Context context;
    private OnItemClickListener listener;

    public interface OnItemClickListener{ void onItemClick(int position);}
    public void setOnClickListener(OnItemClickListener listener){ this.listener = listener; }

    public AdapterSleep(Context context, ArrayList<SleepOptions> sleepOptions) {
        this.context = context;
        this.sleepOptions = sleepOptions;
    }

    @NonNull
    @Override
    public AdapterSleep.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_opcoes_sleep, parent,false);
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

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvSleep;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            tvSleep = itemView.findViewById(R.id.tvDisplayOptionsSleepEId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

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
