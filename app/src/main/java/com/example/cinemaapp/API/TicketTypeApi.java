package com.example.cinemaapp.API;

import com.example.cinemaapp.Models.TicketType;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface TicketTypeApi {
    @Headers( "Content-Type: application/json" )
    @GET("ticketType/")
    Call<ArrayList<TicketType>> getTicketType();


}
