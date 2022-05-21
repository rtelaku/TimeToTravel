package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.GeneralResponse;
import com.example.demo.Register.Models.Admin;
import com.example.demo.Register.Models.Business;
import com.example.demo.Register.Models.Tourist;
import com.example.demo.Register.Repository.AdminRepository;
import com.example.demo.Register.Repository.BusinessRepository;
import com.example.demo.Register.Repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private TouristRepository touristRepository;
    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private AdminRepository adminRepository;

    public UserService(TouristRepository touristRepository, BusinessRepository businessRepository, AdminRepository adminRepository) {
        this.touristRepository = touristRepository;
        this.businessRepository = businessRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public boolean checkIfUserIsValid(String username, String password) {

        Optional<Business> businessOptional = this.businessRepository.findBusinessByUsernameAndPassword(username,password);
        Optional<Tourist> optionalTourist = this.touristRepository.findTouristByUsernameAndPassword(username,password);
        Optional<Admin> optionalAdmin = this.adminRepository.findAdminByUsernameAndPassword(username,password);
        if (!businessOptional.isPresent()) {
            if(!optionalTourist.isPresent()){
                if(!optionalAdmin.isPresent()){
                    return  false;
                }else{
                    return true;
                }
            }else{
                return true;
            }
        } else {
            return true;
        }
    }

    @Override
    public GeneralResponse<?> getUserByUsername(String username) {
        Optional<Business> businessOptional = this.businessRepository.findBusinessByUsername(username);
        Optional<Tourist> optionalTourist = this.touristRepository.findTouristByUsername(username);
        Optional<Admin> optionalAdmin = this.adminRepository.findAdminByUsername(username);

        if(!businessOptional.isPresent()){
            if(!optionalTourist.isPresent()){
                if(!optionalAdmin.isPresent()){
                    return new GeneralResponse.GeneralResponseBuilder(401).setError("User doesn't exist!").build();
                }else{
                    return new GeneralResponse.GeneralResponseBuilder(201).setData(optionalAdmin.get()).build();
                }
            }else{
                return new GeneralResponse.GeneralResponseBuilder(201).setData(optionalTourist.get()).build();
            }
        } else{
            return new GeneralResponse.GeneralResponseBuilder(201).setData(businessOptional.get()).build();
        }

    }


}
