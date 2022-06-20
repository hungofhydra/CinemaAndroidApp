package com.example.cinemaapp.API;

import com.example.cinemaapp.Models.ChangePasswordData;
import com.example.cinemaapp.Models.LoginData;
import com.example.cinemaapp.Models.LoginResponse;
import com.example.cinemaapp.Models.Message;
import com.example.cinemaapp.Models.RegisterData;
import com.example.cinemaapp.Models.RegisterResponse;
import com.example.cinemaapp.Models.Users;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
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

    @Headers( "Content-Type: application/json" )
    @POST("users/dang-ky/")
    Call<RegisterResponse> signUp(@Body RegisterData registerData);

    @GET("users/me/")
    Call<Users> getMyInfo(@Header("Authorization") String auth);

    @POST("users/me/change-password2")
    Call<Message> changePassword(@Header("Authorization") String auth, @Body ChangePasswordData changePasswordData);



}
