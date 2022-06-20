package com.example.cinemaapp.Models;

public class RegisterData {
    private String tenKH;
    private String gioiTinh;
    private String CMND;
    private String SDT;
    private String username;
    private String password;

    public RegisterData(String tenKH, String gioiTinh, String CMND, String SDT, String username, String password) {
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.CMND = CMND;
        this.SDT = SDT;
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
