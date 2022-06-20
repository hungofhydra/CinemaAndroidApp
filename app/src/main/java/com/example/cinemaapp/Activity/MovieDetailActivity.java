package com.example.cinemaapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cinemaapp.API.RetrofitClient;
import com.example.cinemaapp.Models.Movie;
import com.example.cinemaapp.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailActivity extends YouTubeBaseActivity {
    ImageView posterImage;
    TextView movieName, movieType, movieDirector, movieLength, movieContent, movieCountry;
    int movieId;
    String tenTheLoai;
    String api_key = "AIzaSyDqQPc8YPn2peFqZVI3M_KCjfY595UqNEY";
    YouTubePlayerView youTubePlayerView;
    Button btn;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        movieName = findViewById(R.id.textNameMovie);
        movieType = findViewById(R.id.textTypeMovie);
        movieDirector = findViewById(R.id.textDirectorMovie);
        movieLength = findViewById(R.id.textLengthMovie);
        movieCountry = findViewById(R.id.textCountryMovie);
        movieContent = findViewById(R.id.textContentMovie);
        posterImage = findViewById(R.id.imageview_movie_poster);
        btn = findViewById(R.id.button_booking);
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
            movieId =  savedInstanceState.getInt("MOVIE_ID");
            tenTheLoai =  savedInstanceState.getString("TEN_THE_LOAI");
        }

        movieType.setText("Thể loại: " + tenTheLoai);
        Call<Movie> getMovieCall = RetrofitClient.getMovieApi().getMovieById(movieId);
        getMovieCall.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie movie = response.body();
                setProfile(movie);
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieDetailActivity.this, BookingActivity.class);
                intent.putExtra("MOVIE_ID", movieId);
                intent.putExtra("MOVIE_NAME", movieName.getText());
                startActivity(intent);
            }
        });

    }

    private void setProfile(Movie movie){
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt( "maPhim", movie.id);
        editor.commit();
        movieName.setText(movie.tenPhim);
        movieDirector.setText("Đạo diễn: " + movie.daoDien);
        movieLength.setText("Thời lượng: " + movie.thoiLuong + " phút");
        movieCountry.setText("Nước sản xuất: " + movie.nuocSanXuat);
        movieContent.setText("Nội dung: " + movie.noiDungPhim);
        setVideo(movie.trailer);
        Picasso.get().load(movie.poster).into(posterImage);
    }
    private void setVideo(String youTubeUrl){
        YouTubePlayerView ytPlayer = (YouTubePlayerView)findViewById(R.id.ytPlayer);
        ytPlayer.initialize(
                api_key,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(
                            YouTubePlayer.Provider provider,
                            YouTubePlayer youTubePlayer, boolean b)
                    {
                        youTubePlayer.loadVideo(getYouTubeId(youTubeUrl));
                        youTubePlayer.play();
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult
                                                                youTubeInitializationResult)
                    {
                        Toast.makeText(getApplicationContext(), "Video player Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private String getYouTubeId (String youTubeUrl) {
        String pattern = "(?<=youtu.be/|watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(youTubeUrl);
        if(matcher.find()){
            return matcher.group();
        } else {
            return "error";
        }
    }
}