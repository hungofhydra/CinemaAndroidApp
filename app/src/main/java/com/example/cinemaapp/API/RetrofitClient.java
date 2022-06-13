package com.example.cinemaapp.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    Retrofit retrofit;

    public static Retrofit getRetrofit()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.0.2.2:3000/api/v1/")
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

}
