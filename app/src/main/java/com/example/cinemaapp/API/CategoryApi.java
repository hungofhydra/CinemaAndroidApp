package com.example.cinemaapp.API;

import com.example.cinemaapp.Models.Category;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface CategoryApi {

    @Headers( "Content-Type: application/json" )
    @GET("category/{id}")
    Call<Category> getCategoryById(@Path("id") int id);
}
