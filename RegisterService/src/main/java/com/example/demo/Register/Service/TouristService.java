package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.LoginHelper;
import com.example.demo.Register.Helper.TouristHelper;
import com.example.demo.Register.Models.Tourist;

import com.example.demo.Register.Repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristService implements ITouristService {

    @Autowired
    private TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    @Override
    public Tourist getTourist(int id) {
        Optional<Tourist> touristObtional = this.touristRepository.findById(id);
        return touristObtional.get();
    }

    @Override
    public Tourist getTouristByUsernameAndPassword(LoginHelper loginHelper) {
       Optional<Tourist> touristOptional = this.touristRepository.findTouristByUsernameAndPassword(loginHelper.getUsername(), loginHelper.getPassword());
       return touristOptional.get();
    }

    @Override
    public Tourist getTouristByUsername(String username) {
      Optional<Tourist> tourist = this.touristRepository.findTouristByUsername(username);

      return tourist.get();
    }

    @Override
    public List<Tourist> getAllTourists() {
        return this.touristRepository.findAll();
    }

    @Override
    public void createTourist(TouristHelper touristHelper) {
        Tourist tourist = new Tourist(touristHelper.getFull_name(), touristHelper.getAge(), touristHelper.getGender(),
                touristHelper.getEmail(), touristHelper.getPassword(), touristHelper.getUsername(), touristHelper.getRole(), touristHelper.getStatus());
        this.touristRepository.save(tourist);
    }

    @Override
    public void deleteTourist(int id) {
        this.touristRepository.deleteById(id);
    }

    @Override
    public long getTouristsNumber() {
        return this.touristRepository.count();
    }
}