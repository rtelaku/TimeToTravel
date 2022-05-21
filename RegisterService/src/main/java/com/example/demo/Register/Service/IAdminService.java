package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.RegisterHelper;
import com.example.demo.Register.Models.Admin;

import java.util.List;

public interface IAdminService {

    List<Admin> getAllAdmins();

    void createAdmin(Admin admin);

    Admin register(RegisterHelper registerHelper);
}
