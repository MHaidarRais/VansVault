package com.rais.haidar.vansvault.Main.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rais.haidar.vansvault.Main.model.ArticlesItem;
import com.rais.haidar.vansvault.R;

import java.util.List;

class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {


    Context context;
    List<ArticlesItem> articlesItems;
    public static final String WebUrl = "https://newsapi.org/v2/";


    public MainAdapter(Context context, List<ArticlesItem> data) {
        this.context = context;
        this.articlesItems = data;

    }


    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, final int i) {
        mainViewHolder.txtJudulBerita.setText(articlesItems.get(i).getTitle());
        mainViewHolder.txtAuthorBerita.setText(articlesItems.get(i).getAuthor());
        mainViewHolder.txtDeskripsiBerita.setText(articlesItems.get(i).getDescription());

        Glide.with(context)
                .load(articlesItems.get(i).getUrlToImage())
                .into(mainViewHolder.imgGambarBerita);

        mainViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("detailAuthor",articlesItems.get(i).getAuthor());
                intent.putExtra("detailTitle",articlesItems.get(i).getTitle());
                intent.putExtra("detailDeskripsi",articlesItems.get(i).getDescription());
                intent.putExtra("detailGambar",articlesItems.get(i).getUrlToImage());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return articlesItems.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        TextView txtJudulBerita,txtDeskripsiBerita,txtAuthorBerita;
        ImageView imgGambarBerita;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            txtJudulBerita = itemView.findViewById(R.id.txtJudulBerita);
            txtAuthorBerita = itemView.findViewById(R.id.txtAuthorBerita);
            txtDeskripsiBerita = itemView.findViewById(R.id.txtDeskripsiBerita);
            imgGambarBerita = itemView.findViewById(R.id.imgGambarBerita);

        }
    }
}
