package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.RegisterHelper;
import com.example.demo.Register.Models.Admin;
import com.example.demo.Register.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return this.adminRepository.findAll();
    }

    @Override
    public void createAdmin(Admin admin) {
        Admin newAdmin = new Admin(admin.getName(), admin.getEmail(), admin.getSurname(), admin.getUsername(), admin.getPassword(), admin.getGender());
        this.adminRepository.save(newAdmin);
    }

    @Override
    public Admin register(RegisterHelper register) {
        return null;
    }

}
