package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.TouristPlaceHelper;
import com.example.demo.Register.Models.TouristPlace;

import java.util.List;

public interface ITouristPlaceService {

    void createTouristPlace(TouristPlaceHelper touristPlaceHelper, String cityName);

    TouristPlace getToruistPlace(int id);

    List<TouristPlace> getAllTouristPlaces();

    List<TouristPlace> getAllTouristPlacesByCityName(String cityName);

    List<String> getAllTouristPlacesNames();
}
