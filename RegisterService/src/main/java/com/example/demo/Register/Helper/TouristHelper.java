package com.example.demo.Register.Helper;

import java.io.Serializable;

public class TouristHelper implements Serializable {

    private String full_name;
    private int age;
    private char gender;
    private String email;
    private String password;
    private String username;
    private String role;
    private String status;


    public TouristHelper(String full_name, int age, char gender, String email, String password, String username, String role,String status) {
        this.full_name=full_name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
        this.status=status;
    }

    public String getFull_name() {
        return full_name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getStatus() {
        return status;
    }
}
