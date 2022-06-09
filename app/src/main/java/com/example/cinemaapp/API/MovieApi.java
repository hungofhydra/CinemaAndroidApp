package com.example.cinemaapp.API;
import com.example.cinemaapp.Models.Movie;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface MovieApi {
    MovieApi movieAPI = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/api/v1")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi.class);


    @GET("/movies/1")
    Call<Movie> movieDetail();
}
