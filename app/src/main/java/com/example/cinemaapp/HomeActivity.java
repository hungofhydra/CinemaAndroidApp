package com.example.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.cinemaapp.Models.LoginResponse;

public class HomeActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView = findViewById(R.id.textView_test);
        LoginResponse loginResponse = (LoginResponse) getIntent().getSerializableExtra("LOGIN_RESPONSE");
        String infor = loginResponse.toString();
        textView.setText(infor);
    }
}