package com.example.cinemaapp.Models;

public class Test {
    private String movieName;
    private String movieDate;
    private Integer movieImage;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public Integer getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(Integer movieImage) {
        this.movieImage = movieImage;
    }

    public Test(String movieName, String movieDate, Integer movieImage) {
        this.movieName = movieName;
        this.movieDate = movieDate;
        this.movieImage = movieImage;
    }
}
