package com.example.cinemaapp.Models.TicketOfUser;

public class Ghe {
    public int id;
    public String vitriDay;
    public String vitriCot;

    @Override
    public String toString() {
        return "Ghe{" +
                "id=" + id +
                ", vitriDay='" + vitriDay + '\'' +
                ", vitriCot='" + vitriCot + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVitriDay() {
        return vitriDay;
    }

    public void setVitriDay(String vitriDay) {
        this.vitriDay = vitriDay;
    }

    public String getVitriCot() {
        return vitriCot;
    }

    public void setVitriCot(String vitriCot) {
        this.vitriCot = vitriCot;
    }

    public Ghe(int id, String vitriDay, String vitriCot) {
        this.id = id;
        this.vitriDay = vitriDay;
        this.vitriCot = vitriCot;
    }
}
