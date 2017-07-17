package com.sample.spotspoontest.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.sample.spotspoontest.R;
import com.sample.spotspoontest.controller.ImageSliderAdapter;
import com.sample.spotspoontest.model.Album;
import com.sample.spotspoontest.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;


public class HomeFragment extends Fragment {

    ViewPager mPager;
    CircleIndicator indicator;
    ArrayList<Album> arrayListAlbum = new ArrayList<>();
    Gson mGson;
    public HomeFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mGson = new GsonBuilder().create();
        initiateData();
        setUI(view);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event

    private void setUI(View view){
        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPager.setAdapter(new ImageSliderAdapter(getActivity() , arrayListAlbum));
        indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        indicator.setViewPager(mPager);
    }

    private void initiateData()
    {

        try {
            String jsonDataAlbum = Utils.readJsonFileFromAssets(getActivity().getAssets().open("albumJson.json"));
            JSONObject jsonObjectAlbum = new JSONObject(jsonDataAlbum);
            JSONArray jsonArrayAlbum = jsonObjectAlbum.getJSONArray("album");

            for(int i = 0 ; i < jsonArrayAlbum.length() ; i ++) {
                Album album = mGson.fromJson(jsonArrayAlbum.getJSONObject(i).toString(), Album.class);
                arrayListAlbum.add(album);
            }
        }catch (IOException ioE){
            Toast.makeText(getActivity(), "Something went wrong while reading file.", Toast.LENGTH_SHORT).show();
        }catch (JSONException jsonE)
        {

        }
    }
}
