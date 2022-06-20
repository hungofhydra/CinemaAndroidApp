package com.example.cinemaapp.Models;

public class UpdateSeat {
    String trangThai;

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "UpdateChair{" +
                "trangThai='" + trangThai + '\'' +
                '}';
    }

    public UpdateSeat(String trangThai) {
        this.trangThai = trangThai;
    }
}
