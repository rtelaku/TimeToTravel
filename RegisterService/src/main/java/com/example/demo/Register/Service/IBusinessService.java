package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.BusinessHelper;
import com.example.demo.Register.Helper.LoginHelper;
import com.example.demo.Register.Models.Business;

import java.util.List;

public interface IBusinessService {

    Business getBusiness(int id);

    Business getBusinessByUsernameAndPassword(LoginHelper loginHelper);

    Business getBusinessByUsername(String username);

    List<Business> getAllBusinesses();

    void createBusiness(BusinessHelper businessHelper);

    void deleteBusiness(int id);

    void editBusiness(BusinessHelper businessHelper);

    void editBusinessStatus(int id, String status);

    long getBusinessesNumber();

}
