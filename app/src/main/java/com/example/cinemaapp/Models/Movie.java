package com.example.cinemaapp.Models;

public class Movie {

    public int id;
    public String tenPhim;
    public String noiDungPhim;
    public String daoDien;
    public String nuocSanXuat;
    public String thoiLuong;
    public String trailer;
    public String poster;
    public String trangThai;
    public TheLoaiPhim theLoaiPhim;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", tenPhim='" + tenPhim + '\'' +
                ", noiDungPhim='" + noiDungPhim + '\'' +
                ", daoDien='" + daoDien + '\'' +
                ", nuocSanXuat='" + nuocSanXuat + '\'' +
                ", thoiLuong='" + thoiLuong + '\'' +
                ", trailer='" + trailer + '\'' +
                ", poster='" + poster + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", theLoaiPhim=" + theLoaiPhim +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public TheLoaiPhim getTheLoaiPhim() {
        return theLoaiPhim;
    }

    public void setTheLoaiPhim(TheLoaiPhim theLoaiPhim) {
        this.theLoaiPhim = theLoaiPhim;
    }

    public Movie(int id, String tenPhim, String noiDungPhim, String daoDien, String nuocSanXuat, String thoiLuong, String trailer, String poster, String trangThai, TheLoaiPhim theLoaiPhim) {
        this.id = id;
        this.tenPhim = tenPhim;
        this.noiDungPhim = noiDungPhim;
        this.daoDien = daoDien;
        this.nuocSanXuat = nuocSanXuat;
        this.thoiLuong = thoiLuong;
        this.trailer = trailer;
        this.poster = poster;
        this.trangThai = trangThai;
        this.theLoaiPhim = theLoaiPhim;
    }
//    public int id;
//    public int maTheLoai;
//    public String tenPhim;
//    public String noiDungPhim;
//    public String daoDien;
//    public String nuocSanXuat;
//    public String thoiLuong;
//    public String trailer;
//    public String poster;
//    public String trangThai;
//
//    @Override
//    public String toString() {
//        return "Movie{" +
//                "id=" + id +
//                ", maTheLoai=" + maTheLoai +
//                ", tenPhim='" + tenPhim + '\'' +
//                ", noiDungPhim='" + noiDungPhim + '\'' +
//                ", daoDien='" + daoDien + '\'' +
//                ", nuocSanXuat='" + nuocSanXuat + '\'' +
//                ", thoiLuong='" + thoiLuong + '\'' +
//                ", trailer='" + trailer + '\'' +
//                ", poster='" + poster + '\'' +
//                ", trangThai='" + trangThai + '\'' +
//                '}';
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getMaTheLoai() {
//        return maTheLoai;
//    }
//
//    public void setMaTheLoai(int maTheLoai) {
//        this.maTheLoai = maTheLoai;
//    }
//
//    public String getTenPhim() {
//        return tenPhim;
//    }
//
//    public void setTenPhim(String tenPhim) {
//        this.tenPhim = tenPhim;
//    }
//
//    public String getNoiDungPhim() {
//        return noiDungPhim;
//    }
//
//    public void setNoiDungPhim(String noiDungPhim) {
//        this.noiDungPhim = noiDungPhim;
//    }
//
//    public String getDaoDien() {
//        return daoDien;
//    }
//
//    public void setDaoDien(String daoDien) {
//        this.daoDien = daoDien;
//    }
//
//    public String getNuocSanXuat() {
//        return nuocSanXuat;
//    }
//
//    public void setNuocSanXuat(String nuocSanXuat) {
//        this.nuocSanXuat = nuocSanXuat;
//    }
//
//    public String getThoiLuong() {
//        return thoiLuong;
//    }
//
//    public void setThoiLuong(String thoiLuong) {
//        this.thoiLuong = thoiLuong;
//    }
//
//    public String getTrailer() {
//        return trailer;
//    }
//
//    public void setTrailer(String trailer) {
//        this.trailer = trailer;
//    }
//
//    public String getPoster() {
//        return poster;
//    }
//
//    public void setPoster(String poster) {
//        this.poster = poster;
//    }
//
//    public String getTrangThai() {
//        return trangThai;
//    }
//
//    public void setTrangThai(String trangThai) {
//        this.trangThai = trangThai;
//    }
//
//    public Movie(int id, int maTheLoai, String tenPhim, String noiDungPhim, String daoDien, String nuocSanXuat, String thoiLuong, String trailer, String poster, String trangThai) {
//        this.id = id;
//        this.maTheLoai = maTheLoai;
//        this.tenPhim = tenPhim;
//        this.noiDungPhim = noiDungPhim;
//        this.daoDien = daoDien;
//        this.nuocSanXuat = nuocSanXuat;
//        this.thoiLuong = thoiLuong;
//        this.trailer = trailer;
//        this.poster = poster;
//        this.trangThai = trangThai;
//    }
}
