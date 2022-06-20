package com.example.cinemaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.cinemaapp.Activity.LoginActivity;
import com.example.cinemaapp.Activity.TicketHistoryActivity;
import com.example.cinemaapp.Activity.UserActivity;
import com.example.cinemaapp.Models.LoginResponse;
import com.example.cinemaapp.databinding.ActivityHomePageMovieBinding;
import com.example.cinemaapp.databinding.NavHeaderHomePageMovieBinding;
import com.google.android.material.navigation.NavigationView;

public class HomePageMovie extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomePageMovieBinding binding;
    private NavHeaderHomePageMovieBinding binding2;
    private LoginResponse loginResponse;

    String token;
    String userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomePageMovieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //loginResponse = (LoginResponse) getIntent().getSerializableExtra("LOGIN_RESPONSE");



        setSupportActionBar(binding.appBarHomePageMovie.toolbar2);
        binding.appBarHomePageMovie.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageMovie.this, UserActivity.class);
                intent.putExtra("TOKEN", token);
                startActivity(intent);
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_ticket)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_page_movie);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if (id == R.id.nav_ticket){
                    Intent newIntent = new Intent(HomePageMovie.this, TicketHistoryActivity.class);
                    startActivity(newIntent);
                }
                return true;
            }
        });

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                loginResponse= null;
                userName = null;
            } else {
                loginResponse= (LoginResponse) extras.getSerializable("LOGIN_RESPONSE");
                userName = extras.getString("USERNAME");
                token = loginResponse.getToken();

                View headerView = navigationView.getHeaderView(0);
                TextView navUsername = (TextView) headerView.findViewById(R.id.header_title);
                navUsername.setText(userName);


            }
        } else {
            loginResponse = (LoginResponse) savedInstanceState.getSerializable("TOKEN");
            userName =  savedInstanceState.getString("USERNAME");

        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page_movie, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_page_movie);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                Intent intent = new Intent(HomePageMovie.this, LoginActivity.class);
                startActivity(intent);
                return true;


            default:
                return super.onOptionsItemSelected(item);

        }
    }
}