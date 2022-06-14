package com.example.cinemaapp.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Schedule {
    private int id;
    private int maPhong;
    private int maPhim;
    private Date ngayChieu;
    private String trangThai;

    public int getId() {
        return id;
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

    public int getMaPhim() {
        return maPhim;
    }

    public void setMaPhim(int maPhim) {
        this.maPhim = maPhim;
    }

    public Date getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dateFormat.format(this.ngayChieu);
        return strDate;
    }

    public Schedule(int id, int maPhong, int maPhim, Date ngayChieu, String trangThai) {
        this.id = id;
        this.maPhong = maPhong;
        this.maPhim = maPhim;
        this.ngayChieu = ngayChieu;
        this.trangThai = trangThai;
    }
}
