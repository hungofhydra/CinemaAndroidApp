package com.example.cinemaapp.ui.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinemaapp.API.RetrofitClient;
import com.example.cinemaapp.Models.Movie;
import com.example.cinemaapp.Adapter.MovieAdapter;
import com.example.cinemaapp.R;
import com.example.cinemaapp.databinding.FragmentCurrentlyShowingBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentCurrentlyShowing extends Fragment {
    private RecyclerView recyclerView;
    private FragmentCurrentlyShowingBinding binding;
    private ArrayList<Movie> movieList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_currently_showing, container, false);

        binding = FragmentCurrentlyShowingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = root.findViewById(R.id.recyclerViewCurrentlyShowing);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        Call<ArrayList<Movie>> getAllMovieCall = RetrofitClient.getMovieApi().getAllMovies();
        getAllMovieCall.enqueue(new Callback<ArrayList<Movie>>() {
            @Override
            public void onResponse(Call<ArrayList<Movie>> call, Response<ArrayList<Movie>> response) {
                movieList = response.body();
                ArrayList<Movie> newList = new ArrayList<Movie>();
                newList = filterMovie(movieList);
                MovieAdapter movieAdapter = new MovieAdapter(newList, FragmentCurrentlyShowing.this);
                recyclerView.setAdapter(movieAdapter);

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
            if (movie.trangThai.equals("??ang chi???u")) {
                movieCurrentlyShowing.add(movie);

            }
        }

        return movieCurrentlyShowing;
    }
}