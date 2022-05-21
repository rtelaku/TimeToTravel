package com.example.demo.Register.Helper;

import java.io.Serializable;

public class CityHelper implements Serializable {
    private String name;
    private String zipCode;

    public CityHelper(String name, String zipCode) {
        this.name = name;
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
