package com.example.demo.Register.Helper;

import java.io.Serializable;

public class RoomFeatureHelper implements Serializable {
    private String feature;
    private String roomType;

    public RoomFeatureHelper(String feature, String roomType) {
        this.feature = feature;
        this.roomType = roomType;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
