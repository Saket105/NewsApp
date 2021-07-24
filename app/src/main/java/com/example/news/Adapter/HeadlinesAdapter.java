package com.example.news.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.news.Models.Articles;
import com.example.news.R;

import java.util.List;

public class HeadlinesAdapter extends RecyclerView.Adapter<HeadlinesAdapter.ViewHolder> {

    private Context context;
    private List<Articles> articles;

    public HeadlinesAdapter(Context context, List<Articles> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeadlinesAdapter.ViewHolder holder, int position) {
        Articles a = articles.get(position);
        holder.title.setText(a.getTitle());
        holder.description.setText(a.getDescription());
        holder.source.setText(a.getSource().getName());
        holder.date.setText(a.getPublishedAt());
        holder.content.setText(a.getContent());

        String imageUrl = a.getUrlToImage();
        Glide.with(context).load(imageUrl).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title,date,source, description, content;
        ImageView imageView;
        RelativeLayout cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            date = itemView.findViewById(R.id.tvDate);
            source = itemView.findViewById(R.id.tvSource);
            description = itemView.findViewById(R.id.tvDescription);
            content = itemView.findViewById(R.id.tvContent);

            imageView = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
