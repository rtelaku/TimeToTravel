package com.example.demo.Core.Domain;

import com.example.demo.Core.Entities.Business;
import com.example.demo.Core.Entities.Reservation;
import com.example.demo.Core.Entities.Room;
import com.example.demo.Core.Entities.Tourist;
import com.example.demo.Core.Helper.ReservationHelper;
import com.example.demo.Core.Helper.RoomHelper;
import com.example.demo.Core.OutputPort.ReservationRepository;
import com.example.demo.Core.OutputPort.RoomOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Component
public class ReservationDomain {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomOutputPort roomOutputPort;

    public ReservationDomain(ReservationRepository reservationRepository,RoomOutputPort roomOutputPort) {
        this.reservationRepository = reservationRepository;
        this.roomOutputPort = roomOutputPort;
    }

    public void createReservation(ReservationHelper reservationHelper, Room room, Business business, Tourist tourist){
        int daysNumber = getNumberOfDays(reservationHelper.getCheckInDate(), reservationHelper.getCheckOutDate());
        double totalPrice=daysNumber*setTotalPrice(room.getRoomPrice(), room.getRoomDiscount());

        Reservation reservation = new Reservation(reservationHelper.getTime(), reservationHelper.getDate(),
                reservationHelper.getCheckInDate(), reservationHelper.getCheckOutDate(), totalPrice, room.getRoomDiscount(),
                room, business, tourist);

        this.reservationRepository.save(reservation);
    }

    public double setTotalPrice(double roomPrice, double roomDiscount){
       roomPrice=roomPrice-(roomPrice*(roomDiscount/100));
       return roomPrice;
    }

    public int getNumberOfDays(Date checkInDate, Date checkOutDate){
       int numOfDays = (int) Math.round((checkInDate.getTime()-checkOutDate.getTime())/ (double)86400000);
       return Math.abs(numOfDays);
    }

    public void setRoomUnavailable(int roomNumber, Date checkindate){
        LocalDate localDate = LocalDate.now(ZoneId.of("GMT+02:30"));
        Date currentDate = Date.valueOf(localDate);
        if(checkindate==currentDate){
            this.roomOutputPort.setReservedRoomUnavailable(roomNumber);
        }
    }

    public RoomHelper getFirstAvailableRoom(Date newReservationCheckoutDate, Date newReservationCheckinDate, List<RoomHelper> roomHelpers, String businessUsername) {
        LocalDate localDate = LocalDate.now(ZoneId.of("GMT+02:30"));
        Date currentDate = Date.valueOf(localDate);
        if (roomHelpers.size() > 0) {
            for (RoomHelper roomHelper : roomHelpers) {
                List<Reservation> reservations = this.reservationRepository.findReservationByRoomNumber(roomHelper.getRoom_number(), businessUsername, currentDate);

                if (reservations.size() == 0) {
                    return roomHelper;
                }
                for (Reservation r : reservations) {
                    if ((r.getCheckInDate().before(newReservationCheckinDate) && r.getCheckOutDate().before(newReservationCheckoutDate)) || ((r.getCheckInDate().after(newReservationCheckinDate) && r.getCheckInDate().before(newReservationCheckoutDate)) && (r.getCheckOutDate().after(newReservationCheckoutDate)))
                            || (r.getCheckInDate().before(newReservationCheckinDate) && r.getCheckOutDate().after(newReservationCheckoutDate)) || (r.getCheckInDate().after(newReservationCheckinDate) && r.getCheckOutDate().before(newReservationCheckoutDate)) || ((r.getCheckInDate() == newReservationCheckinDate) && (r.getCheckOutDate() == newReservationCheckoutDate))) {
                        System.out.println(newReservationCheckinDate + "-------------" + r.getCheckInDate());
                        System.out.println(newReservationCheckoutDate + "-------------" + r.getCheckOutDate());
                        if (((newReservationCheckinDate.before(r.getCheckInDate()) || newReservationCheckinDate == r.getCheckInDate()) && (newReservationCheckoutDate.before(r.getCheckInDate()) || newReservationCheckoutDate == r.getCheckInDate())) ||
                                ((newReservationCheckinDate.after(r.getCheckOutDate()) || newReservationCheckinDate == r.getCheckOutDate()) && (newReservationCheckoutDate.after(r.getCheckOutDate())))) {
                            return roomHelper;
                        }
                    }
                        if (newReservationCheckinDate.before(r.getCheckInDate()) || newReservationCheckinDate == r.getCheckInDate()) {
                            if (newReservationCheckoutDate.before(r.getCheckInDate()) || newReservationCheckoutDate == r.getCheckInDate()) {
                                return roomHelper;
                            }

                        } else if (newReservationCheckinDate.after(r.getCheckOutDate()) || newReservationCheckinDate == r.getCheckOutDate()) {
                            if (newReservationCheckoutDate.after(r.getCheckOutDate())) {
                                return roomHelper;
                            }
                        } else {
                            return null;
                        }
                    }
                }
            }
            return null;
        }

        @Scheduled(fixedRate = 1000 * 60 * 60 * 6)
        public void updateRoomAvailability () {

            LocalDate localDate = LocalDate.now(ZoneId.of("GMT+02:30"));
            Date currentDate = Date.valueOf(localDate);
            System.out.println("Current Date is: " + currentDate);
            List<Reservation> reservations = this.reservationRepository.getAllReservationsByCheckoutDate(currentDate);
            for (Reservation r : reservations) {
                RoomHelper roomHelper = this.roomOutputPort.getRoomByRoomNumber(r.getRoom().getRoomNumber());
                if (roomHelper.getIs_available() == false) {
                    this.roomOutputPort.setRoomAvailable(roomHelper.getRoom_number());
                }
            }
        }

        @Scheduled(fixedRate = 1000 * 60 * 60 * 6)
        public void updateRoomUnavailability () {
            LocalDate localDate = LocalDate.now(ZoneId.of("GMT+02:30"));
            Date currentDate = Date.valueOf(localDate);

            List<Reservation> reservations = this.reservationRepository.getAllReservationsByCheckinDate(currentDate);
            for (Reservation r : reservations) {
                RoomHelper roomHelper = this.roomOutputPort.getRoomByRoomNumber(r.getRoom().getRoomNumber());
                if (roomHelper.getIs_available() == true) {
                    this.roomOutputPort.setReservedRoomUnavailable(roomHelper.getRoom_number());
                }
            }
        }
}

