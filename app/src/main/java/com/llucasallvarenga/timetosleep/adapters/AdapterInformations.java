package com.llucasallvarenga.timetosleep.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.llucasallvarenga.timetosleep.R;

import java.util.ArrayList;

public class AdapterInformations extends RecyclerView.Adapter<AdapterInformations.ViewHolder> {

    private ArrayList<Informations> informations;
    private OnItemClickListener listener;

    public interface OnItemClickListener{ void onItemClick(int position);}
    public void setOnClickListener(OnItemClickListener listener){ this.listener = listener; }

    public AdapterInformations(ArrayList<Informations> informations) { this.informations = informations; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_information, parent,false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ivIconInformation.setImageResource(informations.get(position).getIcons());
        holder.tvTitleInformation.setText(informations.get(position).getTitlesSections());

        if (position == ( getItemCount() - 1 ) ) holder.divInformation.setBackgroundColor(Color.TRANSPARENT);

    }

    @Override
    public int getItemCount() {
        return informations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivIconInformation;
        TextView tvTitleInformation;
        TextView divInformation;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            ivIconInformation = itemView.findViewById(R.id.ivInformationsId);
            tvTitleInformation = itemView.findViewById(R.id.informationId);
            divInformation = itemView.findViewById(R.id.divInformationId);

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