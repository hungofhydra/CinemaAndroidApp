package com.example.cinemaapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinemaapp.API.RetrofitClient;
import com.example.cinemaapp.Activity.MovieDetailActivity;
import com.example.cinemaapp.Models.Category;
import com.example.cinemaapp.Models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    String tenTheLoai;
    List<Movie> movieList;
    Context context;
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

        Call<Category> getCategoryCall = RetrofitClient.getCategoryApi().getCategoryById(movie.maTheLoai);
        getCategoryCall.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                Category category = response.body();
                tenTheLoai = category.tenTheLoai;
                setInfo(holder,tenTheLoai,movie.tenPhim,movie.poster);
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {

            }
        });
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
