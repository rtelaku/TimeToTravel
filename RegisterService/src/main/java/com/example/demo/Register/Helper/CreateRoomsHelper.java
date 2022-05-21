package com.example.demo.Register.Helper;

import com.example.demo.Register.Models.Room;

import java.util.List;

public class CreateRoomsHelper {

    private List<Room> rooms;

    public CreateRoomsHelper(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
