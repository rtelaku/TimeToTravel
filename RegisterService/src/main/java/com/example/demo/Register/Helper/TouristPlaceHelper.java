package com.example.demo.Register.Helper;

import com.example.demo.Register.Models.City;

import java.io.Serializable;

public class TouristPlaceHelper implements Serializable {
    private String name;
    private City city;

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }
}
