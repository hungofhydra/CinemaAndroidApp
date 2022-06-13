package com.example.cinemaapp.Models;

public class Category {
    public int id;
    public String tenTheLoai;
    public String trangThai;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", tenTheLoai='" + tenTheLoai + '\'' +
                ", trangThai='" + trangThai + '\'' +
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Category(int id, String tenTheLoai, String trangThai) {
        this.id = id;
        this.tenTheLoai = tenTheLoai;
        this.trangThai = trangThai;
    }
}
