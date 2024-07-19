package com.event.managements.controllers;

import com.event.managements.model.Admin;
import com.event.managements.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/adminRegister")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
        try {
            Admin registeredAdmin = adminService.registerAdmin(admin);
            return ResponseEntity.ok(registeredAdmin);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    @PostMapping("/adminlogin")
    public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin) {
        try {
            Admin logAdmin = adminService.loginAdmin(admin);
            return ResponseEntity.ok(logAdmin);  // Returns the Admin object with isAdmin
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
    
    
}
