package com.example.demo.Core.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private Time reservationTime;
    @Column
    private Date reservationDate;
    @Column
    private Date checkInDate;
    @Column
    private Date checkOutDate;
    @Column
    private double totalPrice;
    @Column
    private double discount;
    @Column
    private Room room;
    @Embedded
    private Business business;
    @Embedded
    private Tourist tourist;

    public Reservation(Time reservationTime, Date reservationDate ,Date checkInDate, Date checkOutDate, double totalPrice,double discount ,Room room, Business business, Tourist tourist) {
        this.reservationTime = reservationTime;
        this.reservationDate=reservationDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.discount=discount;
        this.room = room;
        this.business = business;
        this.tourist = tourist;
    }

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public Time getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Time reservationTime) {
        this.reservationTime = reservationTime;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {

        return  checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }
}
