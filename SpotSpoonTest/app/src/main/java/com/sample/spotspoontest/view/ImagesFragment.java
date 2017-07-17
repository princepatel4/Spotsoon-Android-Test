package com.sample.spotspoontest.view;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.spotspoontest.R;
import com.sample.spotspoontest.controller.ImageAdapter;
import com.sample.spotspoontest.model.Album;
import com.sample.spotspoontest.utils.AutoFitGridLayoutManager;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ImagesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ImagesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImagesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    RecyclerView recyclerView;
    ImageAdapter adapter;
    private static ArrayList<Album> arrayListAlbum = new ArrayList<>();

    public ImagesFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ImagesFragment newInstance(ArrayList<Album> arrayList) {
        ImagesFragment fragment = new ImagesFragment();

        arrayListAlbum = arrayList;

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_images, container, false);

        setUI(view);
        return view;
    }

    private void setUI(View view)
    {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_image);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new AutoFitGridLayoutManager(getActivity(), 500));
        adapter = new ImageAdapter(arrayListAlbum, getActivity());
        recyclerView.setAdapter(adapter);
    }

}
