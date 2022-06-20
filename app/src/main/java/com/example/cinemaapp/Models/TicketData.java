package com.example.cinemaapp.Models;

import java.util.Date;

public class TicketData {
    public int maSuatChieu;
    public int maLoaiVe;
    public int maPhong;
    public int maPhim;
    public int maGhe;
    public Date ngayMua;

    public TicketData(int maSuatChieu, int maLoaiVe, int maPhong, int maPhim, int maGhe, Date ngayMua) {
        this.maSuatChieu = maSuatChieu;
        this.maLoaiVe = maLoaiVe;
        this.maPhong = maPhong;
        this.maPhim = maPhim;
        this.maGhe = maGhe;
        this.ngayMua = ngayMua;
    }

    @Override
    public String toString() {
        return "TicketData{" +
                "maSuatChieu=" + maSuatChieu +
                ", maLoaiVe=" + maLoaiVe +
                ", maPhong=" + maPhong +
                ", maPhim=" + maPhim +
                ", maGhe=" + maGhe +
                ", ngayMua=" + ngayMua +
                '}';
    }

    public int getMaSuatChieu() {
        return maSuatChieu;
    }

    public void setMaSuatChieu(int maSuatChieu) {
        this.maSuatChieu = maSuatChieu;
    }

    public int getMaLoaiVe() {
        return maLoaiVe;
    }

    public void setMaLoaiVe(int maLoaiVe) {
        this.maLoaiVe = maLoaiVe;
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

    public int getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(int maGhe) {
        this.maGhe = maGhe;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }
}
