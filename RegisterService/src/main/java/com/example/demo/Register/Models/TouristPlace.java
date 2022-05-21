package com.example.demo.Register.Models;

import javax.persistence.*;

@Entity
public class TouristPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private City city;

    public TouristPlace( String name, City city) {
        this.name = name;
        this.city = city;
    }
    public TouristPlace(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
