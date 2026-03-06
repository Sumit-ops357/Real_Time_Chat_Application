package com.example.Real.Time.Chat.Application.service;

import com.example.Real.Time.Chat.Application.model.User;
import com.example.Real.Time.Chat.Application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired   //Automatically Object will be created
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user)
    {
        if(userRepository.findByEmail(user.getEmail()).isPresent())
        {
            throw new RuntimeException("Email already Exists!!");
        }

        if(userRepository.findByUsername(user.getUsername()).isPresent())
        {
            throw new RuntimeException("Username already exists!!");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setOnline(true);

        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    public User findById(String id)
    {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!!"));
    }

    public void updateUserStatus(String userId,boolean isOnline)
    {
        User user = findById(userId);

        user.setOnline(isOnline);
        userRepository.save(user);
    }
}
