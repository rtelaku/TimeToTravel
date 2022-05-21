package com.example.demo.Register.Models;

import javax.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private int room_number;
    @Column
    private String room_type;
    @Column
    private boolean is_available;
    @Column
    private double price;
    @Column
    private double discount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Business business;

    public Room(int room_number, String room_type, boolean is_available,double price, double discount, Business business) {
        this.room_number = room_number;
        this.room_type = room_type;
        this.is_available = is_available;
        this.price=price;
        this.discount=discount;
        this.business=business;
    }

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
