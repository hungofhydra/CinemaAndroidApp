package com.example.cinemaapp.Models.TicketOfUser;

import com.example.cinemaapp.Models.KhachHang;

public class UserTicket {
    public String username;
    public KhachHang khachHang;

    @Override
    public String toString() {
        return "UserTicket{" +
                "username='" + username + '\'' +
                ", khachHang=" + khachHang +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public UserTicket(String username, KhachHang khachHang) {
        this.username = username;
        this.khachHang = khachHang;
    }
}
