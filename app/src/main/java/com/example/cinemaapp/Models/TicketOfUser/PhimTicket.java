package com.example.cinemaapp.Models.TicketOfUser;

public class PhimTicket {
    public int id;
    public String tenPhim;
    public String daoDien;
    public String poster;

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

    public String getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "PhimTicket{" +
                "id=" + id +
                ", tenPhim='" + tenPhim + '\'' +
                ", daoDien='" + daoDien + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }

    public PhimTicket(int id, String tenPhim, String daoDien, String poster) {
        this.id = id;
        this.tenPhim = tenPhim;
        this.daoDien = daoDien;
        this.poster = poster;
    }
}
