package com.example.cinemaapp.API;

import com.example.cinemaapp.Models.BookingData;
import com.example.cinemaapp.Models.TicketData;
import com.example.cinemaapp.Models.TicketOfUser.TicketDetail;
import com.example.cinemaapp.Models.TicketResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TicketApi {

    @Headers( "Content-Type: application/json" )
    @POST("ticket/")
    Call<TicketResponse> createTicket(@Body TicketData ticketData);


    @Headers( "Content-Type: application/json" )
    @POST("booking/create/")
    Call<Void> createBooking(@Header("Authorization") String auth, @Body BookingData bookingData);

    @GET("booking/user/{id}")
    Call<List<TicketDetail>> getBookedTicketByUserId(@Path("id") int id);
}
