package com.example.cinemaapp.Models;

import java.io.Serializable;
import java.util.Date;

public class UserResponse implements Serializable {
    public int id;
    public String type;
    public String trangThai;
    public String username;
    public String password;
    public Date createdAt;
    public Date updatedAt;

    public UserResponse(int id, String type, String trangThai, String username, String password, Date createdAt, Date updatedAt) {
        this.id = id;
        this.type = type;
        this.trangThai = trangThai;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }




}
