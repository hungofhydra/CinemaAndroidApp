package com.example.cinemaapp.Models;

public class Seat {
    public int id;
    public int maPhong;
    public String trangThai;
    public String vitriDay;
    public String vitriCot;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", maPhong=" + maPhong +
                ", trangThai='" + trangThai + '\'' +
                ", vitriDay='" + vitriDay + '\'' +
                ", vitriCot='" + vitriCot + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getVitriDay() {
        return vitriDay;
    }

    public void setVitriDay(String vitriDay) {
        this.vitriDay = vitriDay;
    }

    public String getVitriCot() {
        return vitriCot;
    }

    public void setVitriCot(String vitriCot) {
        this.vitriCot = vitriCot;
    }

    public Seat(int id, int maPhong, String trangThai, String vitriDay, String vitriCot) {
        this.id = id;
        this.maPhong = maPhong;
        this.trangThai = trangThai;
        this.vitriDay = vitriDay;
        this.vitriCot = vitriCot;
    }
}
