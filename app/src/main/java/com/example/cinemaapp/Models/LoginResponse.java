package com.example.cinemaapp.Models;

public class LoginResponse {
    public String message;
    public UserResponse userResponse;
    public String token;

    public LoginResponse(String message, UserResponse userResponse, String token) {
        this.message = message;
        this.userResponse = userResponse;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserResponse getUser() {
        return userResponse;
    }

    public void setUser(UserResponse userResponse) {
        this.userResponse = userResponse;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
