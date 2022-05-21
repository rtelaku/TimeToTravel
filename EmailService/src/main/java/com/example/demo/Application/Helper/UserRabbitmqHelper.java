package com.example.demo.Application.Helper;

import java.io.Serializable;

public class UserRabbitmqHelper implements Serializable {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
