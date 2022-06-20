package com.example.cinemaapp.API;

import com.example.cinemaapp.Models.Seat;
import com.example.cinemaapp.Models.UpdateSeat;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface SeatApi {
    @Headers( "Content-Type: application/json" )
    @GET("seat/room/{id}")
    Call<ArrayList<Seat>> getSeatByRoomId(@Path("id") int id);

    @Headers( "Content-Type: application/json" )
    @PUT("seat/booked/{id}")
    Call<Void> changeStatus(@Path("id") int id, @Body UpdateSeat trangThai);
}
