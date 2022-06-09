package com.example.cinemaapp.Models;

public class Movie {
    private int maTheLoai;
    private String tenPhim;
    private String noiDungPhim;
    private String daoDien;
    private String nuocSanXuat;
    private String thoiLuong;
    private String trailer;
    private String poster;
    private String trangThai;

    public Movie(int maTheLoai, String tenPhim, String noiDungPhim, String daoDien, String nuocSanXuat, String thoiLuong, String trailer, String poster, String trangThai) {
        this.maTheLoai = maTheLoai;
        this.tenPhim = tenPhim;
        this.noiDungPhim = noiDungPhim;
        this.daoDien = daoDien;
        this.nuocSanXuat = nuocSanXuat;
        this.thoiLuong = thoiLuong;
        this.trailer = trailer;
        this.poster = poster;
        this.trangThai = trangThai;
    }

    public int getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(int maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getNoiDungPhim() {
        return noiDungPhim;
    }

    public void setNoiDungPhim(String noiDungPhim) {
        this.noiDungPhim = noiDungPhim;
    }

    public String getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public String getNuocSanXuat() {
        return nuocSanXuat;
    }

    public void setNuocSanXuat(String nuocSanXuat) {
        this.nuocSanXuat = nuocSanXuat;
    }

    public String getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(String thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
