package com.example.cinemaapp.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Showtime {
    private int id;
    private int maLichChieu;
    private String tenSuatChieu;
    private String trangThai;
    private Date timeStart;
    private Date timeEnd;

    public Showtime(int id, int maLichChieu, String tenSuatChieu, String trangThai, Date timeStart, Date timeEnd) {
        this.id = id;
        this.maLichChieu = maLichChieu;
        this.tenSuatChieu = tenSuatChieu;
        this.trangThai = trangThai;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String startTime = dateFormat.format(this.timeStart);
        String endTime = dateFormat.format(this.timeEnd);
        return startTime + " to " + endTime;



    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaLichChieu() {
        return maLichChieu;
    }

    public void setMaLichChieu(int maLichChieu) {
        this.maLichChieu = maLichChieu;
    }

    public String getTenSuatChieu() {
        return tenSuatChieu;
    }

    public void setTenSuatChieu(String tenSuatChieu) {
        this.tenSuatChieu = tenSuatChieu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }
}
