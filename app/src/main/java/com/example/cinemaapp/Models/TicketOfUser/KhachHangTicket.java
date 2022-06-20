package com.example.cinemaapp.Models.TicketOfUser;

public class KhachHangTicket {
    public int id;
    public String tenKH;
    public String SDT;

    @Override
    public String toString() {
        return "KhachHang{" +
                "id=" + id +
                ", tenKH='" + tenKH + '\'' +
                ", SDT='" + SDT + '\'' +
                '}';
    }

    public KhachHangTicket(int id, String tenKH, String SDT) {
        this.id = id;
        this.tenKH = tenKH;
        this.SDT = SDT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
}
