package com.example.cinemaapp.API;

import com.example.cinemaapp.Models.Seat;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface SeatApi {
    @Headers( "Content-Type: application/json" )
    @GET("seat/room/{id}")
    Call<ArrayList<Seat>> getSeatByRoomId(@Path("id") int id);
}
