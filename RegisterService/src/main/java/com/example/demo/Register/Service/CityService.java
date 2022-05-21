package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.CityHelper;
import com.example.demo.Register.Models.City;
import com.example.demo.Register.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CityService implements ICityService{

    @Autowired
    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void createCity(CityHelper cityHelper) {
        City city = new City(cityHelper.getName(), cityHelper.getZipCode());
        this.cityRepository.save(city);
    }

    @Override
    public City getCityByName(String name) {
        return this.cityRepository.findCityByName(name);
    }

    @Override
    public City getCity(int id) {
        Optional<City> cityOptional= this.cityRepository.findById(id);
        return cityOptional.get();
    }

    @Override
    public List<City> getAllCities() {
        return this.cityRepository.findAll();
    }

    @Override
    public List<String> getAllCitiesNames() {
        return this.cityRepository.getCitiesNames();
    }

    @Override
    public Map<Integer, String> getCitiesNamesAndIds() {
        Map<Integer,String> cityMap = new HashMap<>();

        List<City> cities = this.cityRepository.findAll();

        for (City city : cities) {
            cityMap.put(city.getId(), city.getName());
        }

        return cityMap;
    }
}
