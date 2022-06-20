package com.example.cinemaapp.Models.TicketOfUser;

import java.util.Date;

public class SuatChieuTicket {
    public int id;
    public String tenSuatChieu;
    public Date timeStart;
    public Date timeEnd;

    @Override
    public String toString() {
        return "SuatChieuTicket{" +
                "id=" + id +
                ", tenSuatChieu='" + tenSuatChieu + '\'' +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSuatChieu() {
        return tenSuatChieu;
    }

    public void setTenSuatChieu(String tenSuatChieu) {
        this.tenSuatChieu = tenSuatChieu;
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

    public SuatChieuTicket(int id, String tenSuatChieu, Date timeStart, Date timeEnd) {
        this.id = id;
        this.tenSuatChieu = tenSuatChieu;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }
}
