package com.example.cinemaapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinemaapp.Activity.MovieDetailActivity;
import com.example.cinemaapp.Models.Movie;
import com.example.cinemaapp.R;
import com.example.cinemaapp.ui.Fragment.FragmentCurrentlyShowing;
import com.example.cinemaapp.ui.Fragment.FragmentShowingSoon;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    String tenTheLoai;
    List<Movie> movieList;
    Context context;
    View view;
    public MovieAdapter(List<Movie> movieList, FragmentCurrentlyShowing fragmentCurrentlyShowing){
        this.context = fragmentCurrentlyShowing.getActivity();
        this.movieList = movieList;

    }
    public MovieAdapter(List<Movie> movieList, FragmentShowingSoon fragmentShowingSoon){
        this.context = fragmentShowingSoon.getActivity();
        this.movieList = movieList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.movie_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Movie movie = movieList.get(position);
        tenTheLoai = movie.theLoaiPhim.tenTheLoai;
        setInfo(holder,tenTheLoai,movie.tenPhim,movie.poster);
        holder.textViewTypeMovie.setText(tenTheLoai);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieDetailActivity.class);
                intent.putExtra("MOVIE_ID", movie.id );
                intent.putExtra("TEN_THE_LOAI", holder.textViewTypeMovie.getText());
                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView movieImage;
        TextView textViewMovieName;
        TextView textViewTypeMovie;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.imageview_movie);
            textViewMovieName = itemView.findViewById(R.id.textNameMovie);
            textViewTypeMovie = itemView.findViewById(R.id.textTypeMovie);
        }
    }

    public void setInfo(ViewHolder holder, String tenTheLoai, String tenPhim, String urlImage){

        holder.textViewMovieName.setText(tenPhim);
        holder.textViewTypeMovie.setText(tenTheLoai);
        Picasso.get().load(urlImage).into(holder.movieImage);
    }
}
