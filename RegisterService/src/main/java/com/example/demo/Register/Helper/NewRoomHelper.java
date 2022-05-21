package com.example.demo.Register.Helper;

import java.io.Serializable;

public class NewRoomHelper implements Serializable {
    private String roomType;
    private int roomNumber;
    private String username;
    private int roomPrice;
    private int roomDiscount;

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getRoomDiscount() {
        return roomDiscount;
    }

    public void setRoomDiscount(int roomDiscount) {
        this.roomDiscount = roomDiscount;
    }
}
