package com.event.managements.services;

import com.event.managements.model.User;
import com.event.managements.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User loginUser(User user) {
        User loginUser = userRepository.findByEmail(user.getEmail())
            .orElseThrow(() -> new RuntimeException("Invalid user"));
        if (!loginUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid Username or Password");
        }
        return loginUser;
    }
    
}
