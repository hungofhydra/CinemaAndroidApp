package com.example.cinemaapp.Models;

public class TicketType {
    public int id;
    public String tenLoaiVe;
    public String giaVe;
    public String trangThai;

    @Override
    public String toString() {

        return tenLoaiVe + ": " + giaVe + " vnđ";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiVe() {
        return tenLoaiVe;
    }

    public void setTenLoaiVe(String tenLoaiVe) {
        this.tenLoaiVe = tenLoaiVe;
    }

    public String getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(String giaVe) {
        this.giaVe = giaVe;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public TicketType(int id, String tenLoaiVe, String giaVe, String trangThai) {
        this.id = id;
        this.tenLoaiVe = tenLoaiVe;
        this.giaVe = giaVe;
        this.trangThai = trangThai;
    }
}
