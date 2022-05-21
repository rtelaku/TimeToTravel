package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.LoginHelper;
import com.example.demo.Register.Helper.TouristHelper;
import com.example.demo.Register.Models.Tourist;

import java.util.List;

public interface ITouristService {

    Tourist getTourist(int id);

    Tourist getTouristByUsernameAndPassword(LoginHelper loginHelper);

    Tourist getTouristByUsername(String username);

    List<Tourist> getAllTourists();

    void createTourist(TouristHelper touristHelper);

    void deleteTourist(int id);

    long getTouristsNumber();

}
