package com.sample.spotspoontest.controller;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sample.spotspoontest.R;
import com.sample.spotspoontest.model.Album;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Prince on 16-07-2017.
 */

public class ImageSliderAdapter extends PagerAdapter {

    private ArrayList<Album> arrayListAlbum;
    private LayoutInflater inflater;
    private Context context;

    public ImageSliderAdapter(Context context, ArrayList<Album> arrayListAlbum) {
        this.context = context;
        this.arrayListAlbum = arrayListAlbum;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return arrayListAlbum.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = inflater.inflate(R.layout.layout_slide, view, false);
        ImageView myImage = (ImageView) myImageLayout
                .findViewById(R.id.image);
        TextView textViewAbumtitle = (TextView) myImageLayout.findViewById(R.id.text_album_title);
        TextView textViewSinger = (TextView) myImageLayout.findViewById(R.id.text_singer_name);

        textViewAbumtitle.setText(arrayListAlbum.get(position).getAlbumtitle());
        textViewSinger.setText(arrayListAlbum.get(position).getSinger());
        Picasso.with(context)
                .load(arrayListAlbum.get(position).getImageURL())
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_menu_gallery)
                .into(myImage);

        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
