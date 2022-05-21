package com.example.demo.Register.Controller;

import com.example.demo.Register.Helper.CreateRoomsHelper;
import com.example.demo.Register.Helper.NewRoomHelper;
import com.example.demo.Register.Helper.RoomHelper;
import com.example.demo.Register.Models.Room;
import com.example.demo.Register.Service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/register/room")
public class RoomController {

    @Autowired
    private IRoomService iRoomService;

    public RoomController(IRoomService iRoomService) {
        this.iRoomService = iRoomService;
    }

    @PostMapping("/create/room/{businessUsername}")
    public void createRoom(@RequestBody RoomHelper roomHelper, @PathVariable("businessUsername") String businessUsername){
        this.iRoomService.createRoom(roomHelper, businessUsername);

    }
    @PostMapping("/create/new/room")
    public void createRoomWithNumberAndType(@RequestBody NewRoomHelper newRoomHelper){
        this.iRoomService.createRoomWithNumberAndType(newRoomHelper);
    }
    @PostMapping("/create/room/and/type")
    public void createRoomAndType(@RequestBody NewRoomHelper newRoomHelper) {
        this.iRoomService.createRoomAndType(newRoomHelper);
    }

    @PostMapping("/create/rooms")
    public void createRooms(@RequestBody CreateRoomsHelper createRoomsHelper){
        this.iRoomService.createRooms(createRoomsHelper);
    }

    @PostMapping("/edit/room")
    public void editRoomPriceAndDiscount(@RequestBody NewRoomHelper newRoomHelper){
          this.iRoomService.editRoomPriceAndDiscount(newRoomHelper);
    }

    @GetMapping("/get/room/{id}")
    public Room getRoomById(@PathVariable("id") int id){
        return this.iRoomService.getRoomById(id);
    }

    @GetMapping("/get/all/rooms")
    public List<Room> getAllRooms(){
        return this.iRoomService.getAllRooms();
    }

    @GetMapping("/get/all/rooms/{businessUsername}")
    public List<Room> getAllRoomsByBusinessId(@PathVariable("businessUsername") String businessUsername){
       return this.iRoomService.getAllRoomsByBusinessUsername(businessUsername);
    }

    @GetMapping("/get/all/available/rooms/{roomType}/{businessUsername}")
    public List<Room> getAllAvailableRooms(@PathVariable("roomType") String roomType, @PathVariable("businessUsername") String businessUsername){
        return this.iRoomService.getAllAvailableRooms(roomType, businessUsername);
    }

    @PostMapping("/delete/room/{id}")
    public void deleteRoomById(@PathVariable("id") int id){
        this.iRoomService.deleteRoomById(id);
    }

    @GetMapping("/get/roomtypes/{username}")
    public List<String> getRoomTypesByBusinessId(@PathVariable("username") String username){
        return this.iRoomService.getAllRoomTypesByBusinessId(username);
    }

    @GetMapping("/get/availableroom/{roomType}/{businessUsername}")
    public Room getAvailableRoom(@PathVariable("roomType") String roomType, @PathVariable("businessUsername") String businessUsername){
        return this.iRoomService.getFirstAvailableRoom(roomType, businessUsername);
    }

    @PostMapping("/set/room/unavailable/{roomNumber}")
    public void setReservedRoomUnavailable(@PathVariable("roomNumber") int roomNumber){
      this.iRoomService.setReservedRoomUnavailable(roomNumber);
    }

    @PostMapping("/set/room/available/{roomNumber}")
    public void setRoomAvailable(@PathVariable("roomNumber") int roomNumber){
         this.iRoomService.setRoomAvailable(roomNumber);
    }

    @GetMapping("/get/room/by/roomNumber/{roomNumber}")
    public Room getRoomsByRoomNumber(@PathVariable("roomNumber") int roomNumber){
       return this.iRoomService.getRoomByRoomNumber(roomNumber);
    }

    @GetMapping("/get/rooms/toshow/{businessUsername}")
    public List<Room> getRoomsToShow(@PathVariable("businessUsername") String businessUsername){
      return this.iRoomService.getRoomsToShow(businessUsername);
    }
}
