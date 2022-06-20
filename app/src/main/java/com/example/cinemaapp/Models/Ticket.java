package com.example.cinemaapp.Models;

import java.util.Date;

public class Ticket {
    public int id;
    public int maSuatChieu;
    public int maLoaiVe;
    public int maPhong;
    public int maPhim;
    public Date ngayMua;
    public int maGhe;
    public String trangThai;
    public Date updatedAt;
    public Date createdAt;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", maSuatChieu=" + maSuatChieu +
                ", maLoaiVe=" + maLoaiVe +
                ", maPhong=" + maPhong +
                ", maPhim=" + maPhim +
                ", ngayMua=" + ngayMua +
                ", maGhe=" + maGhe +
                ", trangThai='" + trangThai + '\'' +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public int getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(int maGhe) {
        this.maGhe = maGhe;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Ticket(int id, int maSuatChieu, int maLoaiVe, int maPhong, int maPhim, Date ngayMua, int maGhe, String trangThai, Date updatedAt, Date createdAt) {
        this.id = id;
        this.maSuatChieu = maSuatChieu;
        this.maLoaiVe = maLoaiVe;
        this.maPhong = maPhong;
        this.maPhim = maPhim;
        this.ngayMua = ngayMua;
        this.maGhe = maGhe;
        this.trangThai = trangThai;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }
}
