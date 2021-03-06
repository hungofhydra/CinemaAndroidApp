package com.example.cinemaapp.API;

import com.example.cinemaapp.Models.Movie;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface MovieApi {

    @Headers( "Content-Type: application/json" )
    @GET("movies/")
    Call<ArrayList<Movie>> getAllMovies();

    @GET("movies/{id}")
    Call<Movie> getMovieById(@Path("id") int id);
}
