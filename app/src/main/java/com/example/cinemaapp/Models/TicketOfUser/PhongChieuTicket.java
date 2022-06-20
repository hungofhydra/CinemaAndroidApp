package com.example.cinemaapp.Models.TicketOfUser;

public class PhongChieuTicket {
    public int id;
    public String tenPhong;

    @Override
    public String toString() {
        return "PhongChieuTicket{" +
                "id=" + id +
                ", tenPhong='" + tenPhong + '\'' +
                '}';
    }

    public PhongChieuTicket(int id, String tenPhong) {
        this.id = id;
        this.tenPhong = tenPhong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }
}
