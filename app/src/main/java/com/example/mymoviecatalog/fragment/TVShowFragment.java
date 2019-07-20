package com.example.mymoviecatalog.fragment;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mymoviecatalog.adapter.ListTVShowAdapter;
import com.example.mymoviecatalog.Class.TVShow;
import com.example.mymoviecatalog.activity.MainActivity;
import com.example.mymoviecatalog.R;

import java.util.ArrayList;

public class TVShowFragment extends Fragment {

    private ArrayList<TVShow> tvshows;
    private String[] dataName;
    private String[] dataRuntime;
    private String[] dataReleaseDate;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private RecyclerView rvCategory;


    public TVShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview =  inflater.inflate(R.layout.fragment_tvshow, container, false);

        if(((MainActivity) getActivity()).getSupportActionBar() != null) {
            ((MainActivity) getActivity()).getSupportActionBar().setTitle(R.string.appbartitle_tvshowlist);
        }

        rvCategory = rootview.findViewById(R.id.rv_category_tvshow);
        rvCategory.setHasFixedSize(true);

        prepare();
        addItem();
        showRecyclerList();

        return rootview;
    }




    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name_tvshow);
        dataRuntime = getResources().getStringArray(R.array.data_runtimex_tvshow);
        dataReleaseDate = getResources().getStringArray(R.array.data_releasedate_tvshow);
        dataDescription = getResources().getStringArray(R.array.data_description_tvshow);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo_tvshow);
    }

    private void addItem() {
        tvshows = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            TVShow tvshow = new TVShow();
            tvshow.setPhoto_tvshow(dataPhoto.getResourceId(i, -1));
            tvshow.setName_tvshow(dataName[i]);
            tvshow.setDescription_tvshow(dataDescription[i]);
            tvshow.setRuntime_tvshow(dataRuntime[i]);
            tvshow.setReleasedate_tvshow(dataReleaseDate[i]);
            tvshows.add(tvshow);
        }
//        adapter.setListMovie(tvshows);
    }


    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        ListTVShowAdapter listMovieAdapter = new ListTVShowAdapter();
        listMovieAdapter.setContext(this.getActivity());
        listMovieAdapter.setListTVShow(tvshows); // pakai variabel tvshows di baris 19 pas deklarasi ArrayList<TVShow>
        rvCategory.setAdapter(listMovieAdapter);
    }


}
