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

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder>{

    private List<Album> arrayListAlbum;
    Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewAlbumTitle;
        public ImageView imageViewImage;

        public MyViewHolder(View view) {
            super(view);
            textViewAlbumTitle = (TextView) view.findViewById(R.id.text_album_title);
            imageViewImage = (ImageView) view.findViewById(R.id.image_album_image);
        }
    }


    public ImageAdapter(List<Album> arrayListAlbum, Context mContext) {
        this.arrayListAlbum = arrayListAlbum;
        this.mContext = mContext;
    }

    @Override
    public ImageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_image, parent, false);

        return new ImageAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ImageAdapter.MyViewHolder holder, int position) {
        Album album = arrayListAlbum.get(position);
        holder.textViewAlbumTitle.setText(album.getAlbumtitle());
        Picasso.with(mContext)
                .load(arrayListAlbum.get(position).getImageURL())
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_menu_gallery)
                .resize(200,200)
                .into(holder.imageViewImage);
    }

    @Override
    public int getItemCount() {
        return arrayListAlbum.size();
    }
}
