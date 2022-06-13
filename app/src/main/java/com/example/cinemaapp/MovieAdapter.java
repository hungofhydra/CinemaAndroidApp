package com.example.cinemaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinemaapp.Models.Test;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Test[] tests;
    Context context;
    public MovieAdapter(Test[] tests, FragmentCurrentlyShowing fragmentCurrentlyShowing){
        this.tests = tests;
        this.context = fragmentCurrentlyShowing.getActivity();

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
        final Test test = tests[position];
        holder.textViewMovieName.setText(test.getMovieName());
        holder.textViewData.setText(test.getMovieDate());
        holder.movieImage.setImageResource(test.getMovieImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,test.getMovieName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return tests.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView movieImage;
        TextView textViewMovieName;
        TextView textViewData;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.imageview_movie);
            textViewMovieName = itemView.findViewById(R.id.textNameMovie);
            textViewData = itemView.findViewById(R.id.textdateMovie);
        }
    }
}
