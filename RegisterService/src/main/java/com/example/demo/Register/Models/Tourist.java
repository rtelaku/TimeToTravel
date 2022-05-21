package com.example.demo.Register.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int touristID;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private char gender;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String username;
    @Column
    private String role;
    @Column
    private String status;

    public Tourist(String name, int age, char gender, String email, String password, String username, String role,String status) {

        this.name=name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
        this.status=status;
    }

    public Tourist() {

    }

    public int getTouristID() {
        return touristID;
    }

    public void setTouristID(int touristID) {
        this.touristID = touristID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

