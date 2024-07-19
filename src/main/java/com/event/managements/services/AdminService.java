package com.event.managements.services;

import com.event.managements.model.Admin;
import com.event.managements.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin registerAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin loginAdmin(Admin admin) {
        Admin loginAdmin = adminRepository.findByEmail(admin.getEmail())
            .orElseThrow(() -> new RuntimeException("Invalid admin"));
        if (!loginAdmin.getPassword().equals(admin.getPassword())) {
            throw new RuntimeException("Invalid Username or Password");
        }
        return loginAdmin;
    }
    
    
}
