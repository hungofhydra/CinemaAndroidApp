package com.example.cinemaapp.Models;

public class ChangePasswordData {
    private String oldPassword;
    private String newPassword;
    private int id;

    public ChangePasswordData(String oldPassword, String newPassword, int id) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.id = id;
    }

    @Override
    public String toString() {
        return "ChangePasswordData{" +
                "oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
