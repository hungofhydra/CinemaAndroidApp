package com.example.cinemaapp.API;

import com.example.cinemaapp.Models.Schedule;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ScheduleApi {
    @Headers( "Content-Type: application/json" )
    @GET("schedule/maPhim/{id}")
    Call<ArrayList<Schedule>> getCategoryById(@Path("id") int id);

    @GET("schedule/maphimTrangthai/{id}/{trangthai}")
    Call<ArrayList<Schedule>> getCategoryByMovieIdSatus(@Path("id") int id,@Path("trangthai") String trangthai);
}
