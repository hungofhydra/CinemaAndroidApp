package com.example.cinemaapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinemaapp.API.RetrofitClient;
import com.example.cinemaapp.Models.Movie;
import com.example.cinemaapp.databinding.FragmentShowingSoonBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentShowingSoon extends Fragment {
    private FragmentShowingSoonBinding binding;
    private RecyclerView recyclerView2;
    private ArrayList<Movie> movieList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_showing_soon, container, false);

        binding = FragmentShowingSoonBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        recyclerView2 = root.findViewById(R.id.recyclerViewShowingSoon);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<ArrayList<Movie>> getAllMovieCall = RetrofitClient.getMovieApi().getAllMovies();
        getAllMovieCall.enqueue(new Callback<ArrayList<Movie>>() {
            @Override
            public void onResponse(Call<ArrayList<Movie>> call, Response<ArrayList<Movie>> response) {
                movieList = response.body();
                ArrayList<Movie> newList = new ArrayList<Movie>();
                newList = filterMovie(movieList);

                MovieAdapter movieAdapter = new MovieAdapter(newList, FragmentShowingSoon.this);
                recyclerView2.setAdapter(movieAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<Movie>> call, Throwable t) {

            }
        });




        return root;

    }

    public ArrayList<Movie> filterMovie(ArrayList<Movie> movieList){
        ArrayList<Movie> movieCurrentlyShowing = new ArrayList<Movie>();
        for(Movie movie : movieList) {
            if (movie.trangThai.equals("sắp chiếu")) {
                movieCurrentlyShowing.add(movie);

            }
        }

        return movieCurrentlyShowing;
    }


}