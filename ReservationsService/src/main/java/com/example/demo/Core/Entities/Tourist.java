package com.example.demo.Core.Entities;

import javax.persistence.Embeddable;

@Embeddable
public class Tourist {

    private String touristUsername;
    private String touristName;
    private String touristEmail;

    public Tourist(String touristUsername, String touristEmail,String touristName) {
        this.touristUsername = touristUsername;
        this.touristEmail = touristEmail;
        this.touristName=touristName;
    }

    public Tourist() {
    }

    public String getTouristUsername() {
        return touristUsername;
    }

    public void setTouristUsername(String touristUsername) {
        this.touristUsername = touristUsername;
    }

    public String getTouristEmail() {
        return touristEmail;
    }

    public void setTouristEmail(String touristEmail) {
        this.touristEmail = touristEmail;
    }

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }
}
