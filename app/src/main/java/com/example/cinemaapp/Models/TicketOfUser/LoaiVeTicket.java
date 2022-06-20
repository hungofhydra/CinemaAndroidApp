package com.example.cinemaapp.Models.TicketOfUser;

public class LoaiVeTicket {
    public int id;
    public String tenLoaiVe;

    @Override
    public String toString() {
        return "LoaiVeTicket{" +
                "id=" + id +
                ", tenLoaiVe='" + tenLoaiVe + '\'' +
                '}';
    }

    public LoaiVeTicket(int id, String tenLoaiVe) {
        this.id = id;
        this.tenLoaiVe = tenLoaiVe;
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
}
