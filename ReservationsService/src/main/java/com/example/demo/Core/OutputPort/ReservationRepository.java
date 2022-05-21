package com.example.demo.Core.OutputPort;

import com.example.demo.Core.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    @Query(value = "select * from reservation where business_username=?1", nativeQuery = true)
    List<Reservation> findReservationsByBusinessUsername(String username);

    @Query(value = "select * from reservation where room_type=?1 and business_username=?2", nativeQuery = true)
    List<Reservation> findReservationsByRoomType(String roomType,String businessUsername);

    @Query(value = "select * from reservation where room_number=?1 and business_username=?2 and check_out_date>?3", nativeQuery = true)
    List<Reservation> findReservationByRoomNumber(int roomNumber,String businessUsername, Date currentDate);

    @Query(value = "select * from reservation where check_out_date=?1", nativeQuery = true)
    List<Reservation> getAllReservationsByCheckoutDate(Date date);

    @Query(value = "select * from reservation where check_in_date=?1", nativeQuery = true)
    List<Reservation> getAllReservationsByCheckinDate(Date date);
}
