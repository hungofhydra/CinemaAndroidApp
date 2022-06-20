package com.example.cinemaapp.Models.TicketOfUser;

import java.util.Date;

public class VeTicket {
    public int id;
    public Date ngayMua;
    public SuatChieuTicket suatChieu;
    public LoaiVeTicket loaiVe;
    public PhongChieuTicket phongChieu;

    @Override
    public String toString() {
        return "VeTicket{" +
                "id=" + id +
                ", ngayMua=" + ngayMua +
                ", suatChieu=" + suatChieu +
                ", loaiVe=" + loaiVe +
                ", phongChieu=" + phongChieu +
                ", phim=" + phim +
                ", ghe=" + ghe +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public SuatChieuTicket getSuatChieu() {
        return suatChieu;
    }

    public void setSuatChieu(SuatChieuTicket suatChieu) {
        this.suatChieu = suatChieu;
    }

    public LoaiVeTicket getLoaiVe() {
        return loaiVe;
    }

    public void setLoaiVe(LoaiVeTicket loaiVe) {
        this.loaiVe = loaiVe;
    }

    public PhongChieuTicket getPhongChieu() {
        return phongChieu;
    }

    public void setPhongChieu(PhongChieuTicket phongChieu) {
        this.phongChieu = phongChieu;
    }

    public PhimTicket getPhim() {
        return phim;
    }

    public void setPhim(PhimTicket phim) {
        this.phim = phim;
    }

    public Ghe getGhe() {
        return ghe;
    }

    public void setGhe(Ghe ghe) {
        this.ghe = ghe;
    }

    public VeTicket(int id, Date ngayMua, SuatChieuTicket suatChieu, LoaiVeTicket loaiVe, PhongChieuTicket phongChieu, PhimTicket phim, Ghe ghe) {
        this.id = id;
        this.ngayMua = ngayMua;
        this.suatChieu = suatChieu;
        this.loaiVe = loaiVe;
        this.phongChieu = phongChieu;
        this.phim = phim;
        this.ghe = ghe;
    }

    public PhimTicket phim;
    public Ghe ghe;
}
