package com.example.demo.Core.Helper;

import java.io.Serializable;
import java.util.List;

public class RoomsHelper implements Serializable {

    private List<RoomHelper> rooms;

    public List<RoomHelper> getRooms() {
        return rooms;
    }
}
