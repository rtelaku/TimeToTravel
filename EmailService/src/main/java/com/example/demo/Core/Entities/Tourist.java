package com.example.demo.Core.Entities;

import javax.persistence.Embeddable;

@Embeddable
public class Tourist {

    private String touristEmail;

    public Tourist(String touristEmail) {
        this.touristEmail = touristEmail;
    }

    public Tourist() {
    }

    public String getTouristEmail() {
        return touristEmail;
    }

    public void setTouristEmail(String touristEmail) {
        this.touristEmail = touristEmail;
    }
}