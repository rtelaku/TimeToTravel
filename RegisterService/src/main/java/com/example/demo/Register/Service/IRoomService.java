package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.CreateRoomsHelper;
import com.example.demo.Register.Helper.NewRoomHelper;
import com.example.demo.Register.Helper.RoomHelper;
import com.example.demo.Register.Models.Room;

import java.util.List;

public interface IRoomService {
    void createRoom(RoomHelper roomHelper, String businessUsername);

    void createRooms(CreateRoomsHelper createRoomsHelper);

    void createRoomWithNumberAndType(NewRoomHelper newRoomHelper);

    void createRoomAndType(NewRoomHelper newRoomHelper);

    Room getRoomById(int id);

    List<Room> getAllRooms();

    List<Room> getAllRoomsByBusinessUsername(String businessUsername);

    List<Room> getRoomsToShow(String businessUsername);

    List<Room> getAllAvailableRooms(String roomType,String businessUsername);

    void deleteRoomById(int id);

    void editRoomPriceAndDiscount(NewRoomHelper newRoomHelper);

    List<String> getAllRoomTypesByBusinessId(String username);

    Room getFirstAvailableRoom(String roomType,String businessUsername);

    void setReservedRoomUnavailable(int roomNumber);

    void setRoomAvailable(int roomNumber);

    Room getRoomByRoomNumber(int roomNumber);

}
