package com.sample.spotspoontest.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.spotspoontest.R;
import com.sample.spotspoontest.controller.VideosAdapter;
import com.sample.spotspoontest.model.Album;

import java.util.ArrayList;


public class VideosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static ArrayList<Album> arrayListAlbum = new ArrayList<>();
    VideosAdapter mAdapter;

    RecyclerView recyclerView;
    public VideosFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static VideosFragment newInstance(ArrayList<Album> arrayList) {
        VideosFragment fragment = new VideosFragment();
        arrayListAlbum = arrayList;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_videos, container, false);
        setUI(view);
        return view;
    }

    private void setUI(View view)
    {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_video);

        mAdapter = new VideosAdapter(arrayListAlbum, getActivity().getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}
