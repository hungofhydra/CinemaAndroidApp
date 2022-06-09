package com.example.cinemaapp.API;

import com.example.cinemaapp.Models.LoginData;
import com.example.cinemaapp.Models.LoginResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserApi {

   // UserApi userApi = new Retrofit.Builder()
   //         .baseUrl("http://10.0.2.2:3000/api/v1/")
   //         .addConverterFactory(GsonConverterFactory.create())
   //         .build()
   //         .create(UserApi.class);

    @Headers( "Content-Type: application/json" )
    @POST("users/sign-in/")
    Call<LoginResponse> signIn(@Body LoginData loginData);

}
