package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.CityHelper;
import com.example.demo.Register.Models.City;

import java.util.List;
import java.util.Map;

public interface ICityService {

    void createCity(CityHelper cityHelper);

    City getCityByName(String name);

    City getCity(int id);

    List<City> getAllCities();

    List<String> getAllCitiesNames();

    Map<Integer,String> getCitiesNamesAndIds();

}
