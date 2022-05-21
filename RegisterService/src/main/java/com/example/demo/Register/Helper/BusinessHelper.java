package com.example.demo.Register.Helper;

import java.io.Serializable;

public class BusinessHelper implements Serializable {

    private int id;
    private String name;
    private String email;
    private String password;
    private String username;
    private String tel_Number;
    private String owner_ID;
    private String fiscal_Number;
    private String business_Number;
    private String business_Activity;
    private String cityName;
    private String status;
    private String role;

    public BusinessHelper(int id, String name, String email, String password, String username, String tel_Number, String owner_ID, String fiscal_Number, String business_Number, String business_Activity, String cityName ,String status, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.username = username;
        this.tel_Number = tel_Number;
        this.owner_ID = owner_ID;
        this.fiscal_Number = fiscal_Number;
        this.business_Number = business_Number;
        this.business_Activity = business_Activity;
        this.cityName=cityName;
        this.status = status;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getTel_Number() {
        return tel_Number;
    }

    public String getOwner_ID() {
        return owner_ID;
    }

    public String getFiscal_Number() {
        return fiscal_Number;
    }

    public String getBusiness_Number() {
        return business_Number;
    }

    public String getBusiness_Activity() {
        return business_Activity;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
