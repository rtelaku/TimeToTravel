package com.example.demo.Core.Services;

import com.example.demo.Application.InputPort.ReservationInputPort;
import com.example.demo.Core.Domain.ReservationDomain;
import com.example.demo.Core.Entities.Business;
import com.example.demo.Core.Entities.Reservation;
import com.example.demo.Core.Entities.Room;
import com.example.demo.Core.Entities.Tourist;
import com.example.demo.Core.Helper.BusinessHelper;
import com.example.demo.Core.Helper.ReservationHelper;
import com.example.demo.Core.Helper.RoomHelper;
import com.example.demo.Core.Helper.TouristHelper;
import com.example.demo.Core.OutputPort.BusinessOutputPort;
import com.example.demo.Core.OutputPort.ReservationRepository;
import com.example.demo.Core.OutputPort.RoomOutputPort;
import com.example.demo.Core.OutputPort.TouristOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements ReservationInputPort {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TouristOutputPort touristOutputPort;

    @Autowired
    private ReservationDomain reservationDomain;

    @Autowired
    private RoomOutputPort roomOutputPort;

    @Autowired
    private BusinessOutputPort businessOutputPort;

    public ReservationService(ReservationRepository reservationRepository, TouristOutputPort touristOutputPort, RoomOutputPort roomOutputPort, BusinessOutputPort businessOutputPort) {
        this.reservationRepository = reservationRepository;
        this.touristOutputPort = touristOutputPort;
        this.roomOutputPort = roomOutputPort;
        this.businessOutputPort = businessOutputPort;
    }

    @Override
    public void createReservation(ReservationHelper reservationHelper) {
       reservationDomain=new ReservationDomain(this.reservationRepository, this.roomOutputPort);

       TouristHelper touristHelper = this.touristOutputPort.getTouristByUsername(reservationHelper.getTouristUsername());
       BusinessHelper businessHelper = this.businessOutputPort.getBusinessByUsername(reservationHelper.getBusinessUsername());
       List<RoomHelper> roomHelpers = this.roomOutputPort.getAllAvailableRooms(reservationHelper.getRoomType(), reservationHelper.getBusinessUsername());
       RoomHelper roomHelper = reservationDomain.getFirstAvailableRoom(reservationHelper.getCheckOutDate(), reservationHelper.getCheckInDate(), roomHelpers, reservationHelper.getBusinessUsername());

       Tourist tourist = new Tourist(touristHelper.getUsername(), touristHelper.getEmail(), touristHelper.getName());
       Room room = new Room(roomHelper.getRoom_number(), roomHelper.getRoom_type(),roomHelper.getPrice(),roomHelper.getDiscount());
       Business business = new Business(businessHelper.getName(), businessHelper.getEmail(), businessHelper.getTel_Number(), businessHelper.getUsername());

       reservationDomain.createReservation(reservationHelper, room, business, tourist);
    }

    @Override
    public Reservation getReservationById(int id) {
        Optional<Reservation> optionalReservation = this.reservationRepository.findById(id);
        return optionalReservation.get();
    }

    @Override
    public List<Reservation> getReservationsByUsername(String username) {
        return this.reservationRepository.findReservationsByBusinessUsername(username);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return this.reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getAllReservationsByCheckoutDate(Date date) {
        return this.reservationRepository.getAllReservationsByCheckoutDate(date);
    }

    @Override
    public void deleteReservation(int id) {
     this.reservationRepository.deleteById(id);
    }

    @Override
    public int getRoomReservationNumberByRoomType(String roomType, String businessUsername) {
        List<Reservation> reservations = this.reservationRepository.findReservationsByRoomType(roomType,businessUsername);
        return reservations.size();
    }

    @Override
    public List<String> getReservedRoomTypes(String businessUsername){
        List<Reservation> reservations = this.reservationRepository.findReservationsByBusinessUsername(businessUsername);
        List<String> roomTypes = new ArrayList<String>();
        for(Reservation r : reservations){
            String type = r.getRoom().getRoomType();
            if(!roomTypes.contains(type)){
                roomTypes.add(type);
            }
        }
        return roomTypes;
    }

    @Override
    public double getAmountOfRoomsByType(String roomType,String businessUsername) {
        List<Reservation> reservations = this.reservationRepository.findReservationsByRoomType(roomType,businessUsername);
        double amount =0;
        for(Reservation r : reservations){
            amount+=r.getTotalPrice();
        }
        return amount;
    }

    @Override
    public void  updateRoomAvailability(){
        reservationDomain = new ReservationDomain(this.reservationRepository,this.roomOutputPort);
        this.reservationDomain.updateRoomAvailability();
    }

    @Override
    public RoomHelper checkForAvailableRoom(ReservationHelper reservationHelper) {
        reservationDomain = new ReservationDomain(this.reservationRepository,this.roomOutputPort);
        List<RoomHelper> roomHelpers = this.roomOutputPort.getAllAvailableRooms(reservationHelper.getRoomType(), reservationHelper.getBusinessUsername());
        RoomHelper roomHelper=reservationDomain.getFirstAvailableRoom(reservationHelper.getCheckOutDate(), reservationHelper.getCheckInDate(),
                roomHelpers, reservationHelper.getBusinessUsername());

       return roomHelper;
    }

    @Override
    public int getAllReservationsNumber() {
        List<Reservation> reservations = this.getAllReservations();
        return reservations.size();
    }
}
