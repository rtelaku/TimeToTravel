package com.example.demo.Register.Helper;

import java.io.Serializable;

public class RegisterHelper implements Serializable {
    private String name;
    private String email;
    private String surname;
    private String username;
    private String password;
    private char gender;


    public RegisterHelper(String name, String email, String surname, String username, String password, char gender) {
        this.name = name;
        this.email = email;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.gender = gender;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}