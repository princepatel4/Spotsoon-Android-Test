package com.sample.spotspoontest.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sample.spotspoontest.R;
import com.sample.spotspoontest.model.Album;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Prince on 16-07-2017.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.MyViewHolder> {

    private List<Album> arrayListAlbum;
    Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewAlbumTitle, textViewTime, textViewDescription;
        public ImageView imageViewVideo;

        public MyViewHolder(View view) {
            super(view);
            textViewAlbumTitle = (TextView) view.findViewById(R.id.text_album_title);
            textViewDescription = (TextView) view.findViewById(R.id.text_description);
            textViewTime = (TextView) view.findViewById(R.id.text_time);
            imageViewVideo = (ImageView) view.findViewById(R.id.image_video);
        }
    }


    public VideosAdapter(List<Album> arrayListAlbum, Context mContext) {
        this.arrayListAlbum = arrayListAlbum;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_video, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Album movie = arrayListAlbum.get(position);
        holder.textViewAlbumTitle.setText(movie.getAlbumtitle());
        holder.textViewDescription.setText(movie.getDescription());
        holder.textViewTime.setText(movie.getDate());
        Picasso.with(mContext)
                .load(arrayListAlbum.get(position).getImageURL())
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_menu_gallery)
                .into(holder.imageViewVideo);
    }

    @Override
    public int getItemCount() {
        return arrayListAlbum.size();
    }
}
