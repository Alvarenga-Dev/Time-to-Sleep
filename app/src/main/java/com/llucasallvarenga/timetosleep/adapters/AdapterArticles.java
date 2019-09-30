package com.llucasallvarenga.timetosleep.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.llucasallvarenga.timetosleep.R;

import java.util.ArrayList;

public class AdapterArticles extends RecyclerView.Adapter<AdapterArticles.ViewHolder> {

    private ArrayList<Articles> articles;
    private OnItemClickListener listener;

    public interface OnItemClickListener{ void onItemClick(int position); }
    public void setOnClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public AdapterArticles(ArrayList<Articles> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public AdapterArticles.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_articles, parent,false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterArticles.ViewHolder holder, int position) {
        holder.tvTitleArticle.setText( articles.get(position).getArticle() );
        if (position == ( getItemCount() - 1 ) ) holder.divArticles.setBackgroundColor(Color.TRANSPARENT);

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitleArticle;
        TextView divArticles;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            tvTitleArticle = itemView.findViewById(R.id.articleId);
            divArticles = itemView.findViewById(R.id.divArticlesId);

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