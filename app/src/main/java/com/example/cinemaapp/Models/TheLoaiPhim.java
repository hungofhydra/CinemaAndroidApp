package com.example.cinemaapp.Models;

public class TheLoaiPhim {
    public int id;
    public String tenTheLoai;

    @Override
    public String toString() {
        return "TheLoaiPhim{" +
                "id=" + id +
                ", tenTheLoai='" + tenTheLoai + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public TheLoaiPhim(int id, String tenTheLoai) {
        this.id = id;
        this.tenTheLoai = tenTheLoai;
    }
}
