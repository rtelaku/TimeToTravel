package com.example.demo.Register.Models;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String username;
    @Column
    private String tel_Number;
    @Column
    private String owner_ID;
    @Column
    private String fiscal_Number;
    @Column
    private String business_Number;
    @Column
    private String business_Activity;
    @Column
    private String status;
    @Column
    private String role;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private City city;

    public Business(String name, String email, String password, String username, String tel_Number, String owner_ID, String fiscal_Number, String business_Number, String business_Activity,City city,String status, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.username = username;
        this.tel_Number = tel_Number;
        this.owner_ID = owner_ID;
        this.fiscal_Number = fiscal_Number;
        this.business_Number = business_Number;
        this.business_Activity = business_Activity;
        this.status = status;
        this.role = role;
        this.city=city;
    }

    public Business() {

    }

    public int getId() {
        return id;
    }

    public int getBusiness_ID() {
        return id;
    }

    public void setBusiness_ID(int id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTel_Number() {
        return tel_Number;
    }

    public void setTel_Number(String tel_Number) {
        this.tel_Number = tel_Number;
    }

    public String getOwner_ID() {
        return owner_ID;
    }

    public void setOwner_ID(String owner_ID) {
        this.owner_ID = owner_ID;
    }

    public String getFiscal_Number() {
        return fiscal_Number;
    }

    public void setFiscal_Number(String fiscal_Number) {
        this.fiscal_Number = fiscal_Number;
    }

    public String getBusiness_Number() {
        return business_Number;
    }

    public void setBusiness_Number(String business_Number) {
        this.business_Number = business_Number;
    }

    public String getBusiness_Activity() {
        return business_Activity;
    }

    public void setBusiness_Activity(String business_Activity) {
        this.business_Activity = business_Activity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
