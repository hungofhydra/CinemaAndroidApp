package com.example.cinemaapp.Models;

public class BookingData {
        int maUser;
        int maVe;

    @Override
    public String toString() {
        return "BookingData{" +
                "maUser=" + maUser +
                ", maVe=" + maVe +
                '}';
    }

    public int getMaUser() {
        return maUser;
    }

    public void setMaUser(int maUser) {
        this.maUser = maUser;
    }

    public int getMaVe() {
        return maVe;
    }

    public void setMaVe(int maVe) {
        this.maVe = maVe;
    }

    public BookingData(int maUser, int maVe) {
        this.maUser = maUser;
        this.maVe = maVe;
    }
}
