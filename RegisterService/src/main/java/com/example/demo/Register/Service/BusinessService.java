package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.BusinessHelper;
import com.example.demo.Register.Helper.LoginHelper;
import com.example.demo.Register.Models.Business;
import com.example.demo.Register.Models.City;
import com.example.demo.Register.Repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BusinessService implements IBusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private CityService cityService;

    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @Override
    public Business getBusiness(int id) {
        Optional<Business> businessObtional = this.businessRepository.findById(id);
        return businessObtional.get();
    }

    @Override
    public Business getBusinessByUsernameAndPassword(LoginHelper loginHelper) {
        Optional<Business> businessOptional = this.businessRepository.findBusinessByUsernameAndPassword(loginHelper.getUsername(), loginHelper.getPassword());
        return businessOptional.get();
    }

    @Override
    public Business getBusinessByUsername(String username) {
        Optional<Business> optionalBusiness= this.businessRepository.findBusinessByUsername(username);

        return optionalBusiness.get();
    }

    @Override
    public List<Business> getAllBusinesses() {
        return this.businessRepository.findAll();
    }

    @Override
    public void createBusiness(BusinessHelper businessHelper) {
        City city = this.cityService.getCityByName(businessHelper.getCityName());
        Business business = new Business(businessHelper.getName(), businessHelper.getEmail(), businessHelper.getPassword(),
                businessHelper.getUsername(), businessHelper.getTel_Number(), businessHelper.getOwner_ID(), businessHelper.getFiscal_Number(),
                businessHelper.getBusiness_Number(), businessHelper.getBusiness_Activity(), city ,businessHelper.getStatus(), businessHelper.getRole());
        this.businessRepository.save(business);
    }

    @Override
    public void deleteBusiness(int id) {
        this.businessRepository.deleteById(id);

    }

    @Override
    public void editBusiness(BusinessHelper businessHelper) {
        this.businessRepository.updateBusiness(businessHelper.getId(), businessHelper.getBusiness_Activity(), businessHelper.getBusiness_Number(), businessHelper.getEmail(), businessHelper.getFiscal_Number(),
                businessHelper.getName(), businessHelper.getOwner_ID(), businessHelper.getPassword(), businessHelper.getTel_Number(),
                businessHelper.getUsername(), businessHelper.getStatus(), businessHelper.getRole());
    }

    @Override
    public void editBusinessStatus(int id, String status) {
        Optional<Business> businessOptional = this.businessRepository.findById(id);
        businessOptional.get().setStatus(status);
    }

    @Override
    public long getBusinessesNumber() {
        return this.businessRepository.count();
    }

}
