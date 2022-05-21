package com.example.demo.Register.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String zipCode;
    @OneToMany(mappedBy = "city")
    private Set<TouristPlace>  touristPlaces;

    public City(String name, String zipCode) {
        this.name = name;
        this.zipCode = zipCode;
    }
    public City(){

    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getZipCode(){
        return this.zipCode;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setZipCode(String zipCode){
        this.zipCode=zipCode;
    }
}
