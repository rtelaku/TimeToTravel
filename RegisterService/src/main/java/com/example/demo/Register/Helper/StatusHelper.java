package com.example.demo.Register.Helper;

import java.io.Serializable;

public class StatusHelper implements Serializable {

    private int userId;
    private String status;

    public StatusHelper(int userId, String status) {
        this.userId = userId;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }
}
