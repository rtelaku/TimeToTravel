package com.example.demo.Core.Helper;

import java.io.Serializable;

public class BusinessHelper implements Serializable {

    private String name;
    private String email;
    private String tel_Number;
    private String username;

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

    public String getTel_Number() {
        return tel_Number;
    }

    public void setTel_Number(String tel_Number) {
        this.tel_Number = tel_Number;
    }

    public String getUsername() {
        return username;
    }

}
