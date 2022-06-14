package com.example.cinemaapp.API;

import com.example.cinemaapp.Models.Showtime;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ShowtimeApi {
    @GET("showtime/malichchieutrangthai/{id}/{trangthai}")
    Call<ArrayList<Showtime>> getCategoryByMovieIdSatus(@Path("id") int id, @Path("trangthai") String trangthai);
}
