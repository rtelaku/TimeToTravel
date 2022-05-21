package com.example.demo.Register.Controller;

import com.example.demo.Register.Helper.CityHelper;
import com.example.demo.Register.Models.City;
import com.example.demo.Register.Service.ICityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/register/city")
public class CityController {

    private ICityService iCityService;

    public CityController(ICityService iCityService) {
        this.iCityService = iCityService;
    }

    @PostMapping("/create")
    public void createCity(@RequestBody CityHelper cityHelper){
        this.iCityService.createCity(cityHelper);

    }
    @GetMapping("/get/city/{id}")
    public City getCity(@PathVariable("id") int id){
       return this.iCityService.getCity(id);
    }

    @GetMapping("/get/all/cities")
    public List<City> getAllCities(){
        return this.iCityService.getAllCities();
    }

    @GetMapping("/get/all/names")
    public List<String> getAllCitiesNames(){
        return this.iCityService.getAllCitiesNames();
    }

    @GetMapping("/get/all/names-ids")
    public Map<Integer,String> getAllCitiesNamesAndIds(){
        return this.iCityService.getCitiesNamesAndIds();
    }
}
