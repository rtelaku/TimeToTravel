package com.example.demo.Register.Helper;

import java.io.Serializable;

public class AdminHelper implements Serializable {

    private int adminID;
    private String name;
    private String surname;
    private int age;
    private String username;
    private char gender;
    private String email;
    private String password;
    private String role;


    public AdminHelper(int adminID, String name, String surname, int age, String username, char gender, String email, String password, String role) {
        this.adminID = adminID;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.username = username;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.role = role;
    }


    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
