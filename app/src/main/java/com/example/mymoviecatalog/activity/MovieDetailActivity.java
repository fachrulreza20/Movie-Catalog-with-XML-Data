package com.example.mymoviecatalog.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mymoviecatalog.Class.Movie;
import com.example.mymoviecatalog.R;

public class MovieDetailActivity extends AppCompatActivity {

    TextView name, desc, runtime, releaseDate;
    ImageView myImageView;

    public static final String EXTRA_MOVIE = "extra movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        name = findViewById(R.id.tvName);
        desc = findViewById(R.id.tvDesc);
        runtime = findViewById(R.id.tvRuntime);
        releaseDate = findViewById(R.id.tvReleaseDate);
        myImageView = findViewById(R.id.imgVIew);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.appbartitle_movie);
        }

        name.setText((movie.getName().toUpperCase()));
        desc.setText(movie.getDescription());
        runtime.setText(getString(R.string.text_runtime, movie.getRuntime()));
        releaseDate.setText(getString(R.string.text_releasedate, movie.getReleasedate()));

        Glide.with(this)
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(600,600))
                .into(myImageView);


    }
}
