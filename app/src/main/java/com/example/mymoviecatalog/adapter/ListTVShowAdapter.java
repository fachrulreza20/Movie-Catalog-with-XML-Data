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
import com.example.mymoviecatalog.activity.TVShowDetailActivity;
import com.example.mymoviecatalog.Class.TVShow;
import com.example.mymoviecatalog.R;

import java.util.ArrayList;

public class ListTVShowAdapter extends RecyclerView.Adapter<ListTVShowAdapter.CategoryViewHolder> {


    private Context context;
    private ArrayList<TVShow> listTVShow;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<TVShow> getListTVShow() {
        return listTVShow;
    }

    public void setListTVShow(ArrayList<TVShow> listTVShow) {
        this.listTVShow = listTVShow;
    }

    @NonNull
    @Override
    public ListTVShowAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {


        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new CategoryViewHolder(itemRow);


    }

    @Override
    public void onBindViewHolder(@NonNull ListTVShowAdapter.CategoryViewHolder holder, final int position) {

        holder.tvName.setText(getListTVShow().get(position).getName_tvshow());
        holder.tvDescription.setText(getListTVShow().get(position).getDescription_tvshow());
        Glide.with(context)
                .load(getListTVShow().get(position).getPhoto_tvshow())
                .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TVShow tvshow = getListTVShow().get(position);  /// sebaris code ini utk mempersingkat code TVSHow() dibawah

                //                TVShow tvshow = new TVShow();
                //                tvshow.setName_tvshow(listTVShow.get(position).getName_tvshow());
                //                tvshow.setDescription_tvshow(listTVShow.get(position).getDescription_tvshow());
                //                tvshow.setRuntime_tvshow(listTVShow.get(position).getRuntime_tvshow());
                //                tvshow.setReleasedate_tvshow(listTVShow.get(position).getReleasedate_tvshow());
                //                tvshow.setPhoto_tvshow(listTVShow.get(position).getPhoto_tvshow());

                Intent moveWithObjectIntent = new Intent(getContext(), TVShowDetailActivity.class);
                moveWithObjectIntent.putExtra(TVShowDetailActivity.EXTRA_TVSHOW, tvshow);

                context.startActivity(moveWithObjectIntent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return getListTVShow().size();
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
