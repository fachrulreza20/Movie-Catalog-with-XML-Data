package com.example.mymoviecatalog.adapter;

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
import com.example.mymoviecatalog.activity.MovieDetailActivity;
import com.example.mymoviecatalog.Class.Movie;
import com.example.mymoviecatalog.R;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.CategoryViewHolder> {


    private Context context;
    private ArrayList<Movie> listMovie;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public ListMovieAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {


        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new CategoryViewHolder(itemRow);


    }

    @Override
    public void onBindViewHolder(@NonNull ListMovieAdapter.CategoryViewHolder holder, final int position) {

        holder.tvName.setText(getListMovie().get(position).getName());
        holder.tvDescription.setText(getListMovie().get(position).getDescription());
        Glide.with(context)
                .load(getListMovie().get(position).getPhoto())
                .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Movie movie = getListMovie().get(position);  /// sebaris code ini utk mempersingkat code Movie() dibawah

                //        Movie movie = new Movie();
                //        movie.setName(listMovie.get(position).getName());
                //        movie.setDescription(listMovie.get(position).getDescription());
                //        movie.setRuntime(listMovie.get(position).getRuntime());
                //        movie.setReleasedate(listMovie.get(position).getReleasedate());
                //        movie.setPhoto(listMovie.get(position).getPhoto());

                Intent moveWithObjectIntent = new Intent(getContext(), MovieDetailActivity.class);
                moveWithObjectIntent.putExtra(MovieDetailActivity.EXTRA_MOVIE, movie);
                context.startActivity(moveWithObjectIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvDescription;
        ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txt_name);
            tvDescription = itemView.findViewById(R.id.txt_description);
            imgPhoto = itemView.findViewById(R.id.img_photo);
        }
    }
}
