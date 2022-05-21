package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.TouristPlaceHelper;
import com.example.demo.Register.Models.City;
import com.example.demo.Register.Models.TouristPlace;
import com.example.demo.Register.Repository.TouristPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristPlaceService implements ITouristPlaceService{
    private TouristPlaceRepository touristPlaceRepository;

    @Autowired
    private ICityService iCityService;

    public TouristPlaceService(TouristPlaceRepository touristPlaceRepository, ICityService iCityService) {
        this.touristPlaceRepository = touristPlaceRepository;
        this.iCityService=iCityService;
    }

    @Override
    public void createTouristPlace(TouristPlaceHelper touristPlaceHelper, String cityName) {
        City city = this.iCityService.getCityByName(cityName);
        TouristPlace touristPlace = new TouristPlace(touristPlaceHelper.getName(), city);
        this.touristPlaceRepository.save(touristPlace);
    }

    @Override
    public TouristPlace getToruistPlace(int id) {
        Optional<TouristPlace> touristPlaceOptional = this.touristPlaceRepository.findById(id);

        return touristPlaceOptional.get();
    }

    @Override
    public List<TouristPlace> getAllTouristPlaces() {
        return this.touristPlaceRepository.findAll();
    }

    @Override
    public List<TouristPlace> getAllTouristPlacesByCityName(String cityName) {
        City city = this.iCityService.getCityByName(cityName);

        return this.touristPlaceRepository.getTouristPlacesByCityId(city.getId());

    }

    @Override
    public List<String> getAllTouristPlacesNames() {

        return this.touristPlaceRepository.getTouristPlacesNames();
    }
}
