package com.example.cinemaapp.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.cinemaapp.API.RetrofitClient;
import com.example.cinemaapp.Models.LoginResponse;
import com.example.cinemaapp.Models.Users;
import com.example.cinemaapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    private Users result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        LoginResponse loginResponse = (LoginResponse) getIntent().getSerializableExtra("LOGIN_RESPONSE");
        String token = loginResponse.getToken();

        Call<Users> callMyInfo = RetrofitClient.getUserApi().getMyInfo("Bearer " + token);
        callMyInfo.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                result = response.body();
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });

    }


}