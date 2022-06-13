package com.example.cinemaapp.Models;

public class Users {
    public String username;
    public String type;
    public String trangThai;
    public KhachHang khachHang;

    public Users(String username, String type, String trangThai, KhachHang khachHang) {
        this.username = username;
        this.type = type;
        this.trangThai = trangThai;
        this.khachHang = khachHang;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", type='" + type + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", khachHang=" + khachHang +
                '}';
    }
}
