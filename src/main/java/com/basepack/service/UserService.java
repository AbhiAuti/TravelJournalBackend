package com.basepack.service;

import com.basepack.model.User;
import com.basepack.security.JwtUtil;
import com.basepack.dao.UserRepo;
import com.basepack.exception.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    UserService(UserRepo userRepo_1) {
        this.userRepo = userRepo_1;
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String loginUser(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("Invalid credential");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UserNotFoundException("Invalid credential");
        }

        return jwtUtil.generateToken(email);
    }
}

