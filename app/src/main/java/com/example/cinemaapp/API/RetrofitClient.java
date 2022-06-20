package com.example.cinemaapp.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    Retrofit retrofit;

    public static Retrofit getRetrofit()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://nodejs-cinema-api.herokuapp.com/api/v1/")
                .build();

        return retrofit;
    }

    public static UserApi getUserApi(){
        UserApi userApi = getRetrofit().create(UserApi.class);
        return userApi;
    }

    public static MovieApi getMovieApi(){
        MovieApi movieApi = getRetrofit().create(MovieApi.class);
        return movieApi;
    }
    public static CategoryApi getCategoryApi(){
        CategoryApi categoryApi = getRetrofit().create(CategoryApi.class);
        return categoryApi;
    }

    public static ScheduleApi getScheduleApi(){
        ScheduleApi scheduleApi = getRetrofit().create(ScheduleApi.class);
        return scheduleApi;
    }
    public static ShowtimeApi getShowtimeApi(){
        ShowtimeApi showtimeApi = getRetrofit().create(ShowtimeApi.class);
        return showtimeApi;
    }

    public static TicketTypeApi getTicketTypeApi(){
        TicketTypeApi ticketTypeApi = getRetrofit().create(TicketTypeApi.class);
        return ticketTypeApi;
    }

    public static SeatApi getSeatApi(){
        SeatApi seatApi = getRetrofit().create(SeatApi.class);
        return seatApi;
    }
    public static TicketApi getTicketApi(){
        TicketApi ticketApi = getRetrofit().create(TicketApi.class);
        return ticketApi;
    }
}
