package com.example.demo.Core.OutputPort;

import com.example.demo.Core.Helper.RoomHelper;

import java.util.List;

public interface RoomOutputPort {

    RoomHelper getAvailableRoom(String type, String businessUsername);

    List<RoomHelper> getAllAvailableRooms(String type, String businessUsername);

    RoomHelper getRoomByRoomNumber(int roomNumber);

    void setReservedRoomUnavailable(int roomNumber);

    void setRoomAvailable(int roomNumber);
}
