package com.example.cinemaapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class LoginResponse implements Serializable, Parcelable {
    public String message;
    public UserResponse user;
    public String token;

    public LoginResponse(String message, UserResponse userResponse, String token) {
        this.message = message;
        this.user = userResponse;
        this.token = token;
    }

    protected LoginResponse(Parcel in) {
        message = in.readString();
        token = in.readString();
    }

    public static final Creator<LoginResponse> CREATOR = new Creator<LoginResponse>() {
        @Override
        public LoginResponse createFromParcel(Parcel in) {
            return new LoginResponse(in);
        }

        @Override
        public LoginResponse[] newArray(int size) {
            return new LoginResponse[size];
        }
    };

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse userResponse) {
        this.user = userResponse;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "message='" + message + '\'' +
                ", user=" + user +
                ", token='" + token + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
        dest.writeString(token);
    }
}
