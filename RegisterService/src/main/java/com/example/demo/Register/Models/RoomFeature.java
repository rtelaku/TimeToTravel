package com.example.demo.Register.Models;

import javax.persistence.*;

@Entity
public class RoomFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String feature;
    @Column
    private String room_type;

    public RoomFeature(String feature, String roomType) {
        this.feature = feature;
        this.room_type=roomType;
    }

    public RoomFeature() {
    }

    public int getId() {
        return id;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }
}
