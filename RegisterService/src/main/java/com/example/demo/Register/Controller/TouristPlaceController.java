package com.example.demo.Register.Controller;

import com.example.demo.Register.Helper.TouristPlaceHelper;
import com.example.demo.Register.Models.TouristPlace;
import com.example.demo.Register.Service.ITouristPlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/register/touristPlace")
public class TouristPlaceController {

    private final ITouristPlaceService iTouristPlaceService;

    public TouristPlaceController(ITouristPlaceService iTouristPlaceService) {
        this.iTouristPlaceService = iTouristPlaceService;
    }

    @PostMapping("/create/touristPlace/{cityName}")
    public void creteTouristPlaceByCityName(@RequestBody TouristPlaceHelper touristPlaceHelper, @PathVariable("cityName") String cityName){
        this.iTouristPlaceService.createTouristPlace(touristPlaceHelper, cityName);
    }

    @GetMapping("/get//{id}")
    public TouristPlace getTouristPlace(@PathVariable("id") int id){
        return this.iTouristPlaceService.getToruistPlace(id);
    }

    @GetMapping("/get/all")
    public List<TouristPlace> getAllTouristPlaces(){
        return this.iTouristPlaceService.getAllTouristPlaces();
    }

    @GetMapping("/get/all/{cityName}")
    public List<TouristPlace> getAllTouristPlacesByCityName(@PathVariable("cityName") String cityName){
        return this.iTouristPlaceService.getAllTouristPlacesByCityName(cityName);
    }

    @GetMapping("/get/all/names")
    public List<String> getAllTouristPlacesNames(){
        return this.iTouristPlaceService.getAllTouristPlacesNames();
    }
}
