package com.example.cinemaapp.Models;

public class KhachHang {
    public String tenKH;
    public String gioiTinh;

    @Override
    public String toString() {
        return "KhachHang{" +
                "tenKH='" + tenKH + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", CMND='" + CMND + '\'' +
                ", SDT='" + SDT + '\'' +
                '}';
    }

    public KhachHang(String tenKH, String gioiTinh, String CMND, String SDT) {
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.CMND = CMND;
        this.SDT = SDT;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String CMND;
    public String SDT;
}
