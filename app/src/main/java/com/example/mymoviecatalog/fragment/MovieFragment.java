package com.example.mymoviecatalog.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mymoviecatalog.adapter.ListMovieAdapter;
import com.example.mymoviecatalog.Class.Movie;
import com.example.mymoviecatalog.activity.MainActivity;
import com.example.mymoviecatalog.R;

import java.util.ArrayList;

public class MovieFragment extends Fragment {

    private ArrayList<Movie> movies;
    private String[] dataName;
    private String[] dataRuntime;
    private String[] dataReleaseDate;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private RecyclerView rvCategory;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview =  inflater.inflate(R.layout.fragment_movie, container, false);

        if(((MainActivity) getActivity()).getSupportActionBar() != null) {
            ((MainActivity) getActivity()).getSupportActionBar().setTitle(R.string.appbartitle_movielist);
        }

        rvCategory = rootview.findViewById(R.id.rv_category_movie);
        rvCategory.setHasFixedSize(true);

        prepare();
        addItem();
        showRecyclerList();

        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }







    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataRuntime = getResources().getStringArray(R.array.data_runtimex);
        dataReleaseDate = getResources().getStringArray(R.array.data_releasedate);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setName(dataName[i]);
            movie.setDescription(dataDescription[i]);
            movie.setRuntime(dataRuntime[i]);
            movie.setReleasedate(dataReleaseDate[i]);
            movies.add(movie);
        }
//        adapter.setListMovie(movies);
    }


    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        ListMovieAdapter listMovieAdapter = new ListMovieAdapter();
        listMovieAdapter.setContext(this.getActivity());
        listMovieAdapter.setListMovie(movies); // pakai variabel movies di baris 19 pas deklarasi ArrayList<Movie>
        rvCategory.setAdapter(listMovieAdapter);
    }




}
