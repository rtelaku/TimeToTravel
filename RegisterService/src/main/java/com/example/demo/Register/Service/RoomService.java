package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.CreateRoomsHelper;
import com.example.demo.Register.Helper.NewRoomHelper;
import com.example.demo.Register.Helper.RoomHelper;
import com.example.demo.Register.Models.Business;
import com.example.demo.Register.Models.Room;
import com.example.demo.Register.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements IRoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private IBusinessService iBusinessService;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void createRoom(RoomHelper roomHelper, String businessUsername) {
        Business business = this.iBusinessService.getBusinessByUsername(businessUsername);
       Room room = new Room(roomHelper.getRoomNumber(), roomHelper.getRoomType(), roomHelper.isAvailable(), roomHelper.getPrice(),
               roomHelper.getDiscount(), business);

       this.roomRepository.save(room);
    }

    @Override
    public void createRooms(CreateRoomsHelper createRoomsHelper) {
        this.roomRepository.saveAll(createRoomsHelper.getRooms());
    }

    @Override
    public void createRoomWithNumberAndType(NewRoomHelper newRoomHelper) {
        List<Room> rooms = this.roomRepository.getAllRoomsByType(newRoomHelper.getRoomType());
        double roomPrice = rooms.get(0).getPrice();
        double discount = rooms.get(0).getDiscount();

        RoomHelper roomHelper = new RoomHelper(newRoomHelper.getRoomNumber(), newRoomHelper.getRoomType(), true, roomPrice, discount);

        this.createRoom(roomHelper, newRoomHelper.getUsername());
    }

    @Override
    public void createRoomAndType(NewRoomHelper newRoomHelper) {
        RoomHelper roomHelper = new RoomHelper(newRoomHelper.getRoomNumber(), newRoomHelper.getRoomType(), true, newRoomHelper.getRoomPrice(), newRoomHelper.getRoomDiscount());

        this.createRoom(roomHelper, newRoomHelper.getUsername());
    }

    @Override
    public Room getRoomById(int id) {
        Optional<Room> roomOptional = this.roomRepository.findById(id);
        return roomOptional.get();
    }

    @Override
    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }

    @Override
    public List<Room> getAllRoomsByBusinessUsername(String businessUsername) {
        Business business = this.iBusinessService.getBusinessByUsername(businessUsername);
        return this.roomRepository.getRoomsByBusinessId(business.getBusiness_ID());
    }

    @Override
    public List<Room> getRoomsToShow(String businessUsername) {
        List<String> roomTypes = this.getAllRoomTypesByBusinessId(businessUsername);
        List<Room> roomsToShow  = new ArrayList<>();
           for(String type : roomTypes){
               List<Room> allRooms = this.roomRepository.getAllRoomsByType(type);
               roomsToShow.add(allRooms.get(0));
           }

        return roomsToShow;
    }

    @Override
    public List<Room> getAllAvailableRooms(String roomType, String businessUsername) {
        Business business = this.iBusinessService.getBusinessByUsername(businessUsername);
        return this.roomRepository.findAllAvailableRooms(roomType,business.getBusiness_ID());
    }

    @Override
    public void deleteRoomById(int id) {
      this.roomRepository.deleteById(id);
    }

    @Override
    public void editRoomPriceAndDiscount(NewRoomHelper newRoomHelper) {
        Business business = this.iBusinessService.getBusinessByUsername(newRoomHelper.getUsername());
        this.roomRepository.updateRoomPriceAndDiscount(newRoomHelper.getRoomType(), newRoomHelper.getRoomPrice(),
                newRoomHelper.getRoomDiscount(), business.getBusiness_ID());
    }

    @Override
    public List<String> getAllRoomTypesByBusinessId(String username) {
        List<String> roomTypes = new ArrayList<String>();
        Business business = this.iBusinessService.getBusinessByUsername(username);
        List<Room> rooms = this.roomRepository.getRoomsByBusinessId(business.getBusiness_ID());

        for(Room r : rooms){
            String roomType = r.getRoom_type();
            if(!roomTypes.contains(roomType)) {
                roomTypes.add(roomType);
            }
        }
            return roomTypes;
    }

    @Override
    public Room getFirstAvailableRoom(String roomType,String businessUsername) {
        Business business = this.iBusinessService.getBusinessByUsername(businessUsername);
        List<Room> availableRooms = this.roomRepository.findAllAvailableRooms(roomType,business.getBusiness_ID());
        if(availableRooms.size() > 0){
            return availableRooms.get(0);
        }else{
            return null;
        }
    }

    @Override
    public void setReservedRoomUnavailable(int roomNumber) {
        this.roomRepository.setReservedRoomUnavailable(roomNumber);
    }

    @Override
    public void setRoomAvailable(int roomNumber) {
        this.roomRepository.setRoomAvailable(roomNumber);
    }

    @Override
    public Room getRoomByRoomNumber(int roomNumber) {
        return this.roomRepository.getRoomByRoomNumber(roomNumber);
    }
}
