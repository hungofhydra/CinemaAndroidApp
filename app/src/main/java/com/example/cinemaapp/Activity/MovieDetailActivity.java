package com.example.cinemaapp.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cinemaapp.R;

public class MovieDetailActivity extends AppCompatActivity {
    TextView test;
    int movieId;
    String tenTheLoai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        test = findViewById(R.id.textViewtest);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                movieId= Integer.parseInt(null);
                tenTheLoai = null;
            } else {
                movieId= extras.getInt("MOVIE_ID");
                tenTheLoai = extras.getString("TEN_THE_LOAI");

            }
        } else {
            movieId = savedInstanceState.getInt("MOVIE_ID");
            tenTheLoai =  savedInstanceState.getString("TEN_THE_LOAI");

        }
        test.setText(Integer.toString(movieId) + tenTheLoai);
    }
}