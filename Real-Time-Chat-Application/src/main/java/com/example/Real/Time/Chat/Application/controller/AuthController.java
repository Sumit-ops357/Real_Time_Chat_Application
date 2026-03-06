package com.example.Real.Time.Chat.Application.controller;

import com.example.Real.Time.Chat.Application.model.User;
import com.example.Real.Time.Chat.Application.model.dto.AuthRequest;
import com.example.Real.Time.Chat.Application.model.dto.AuthResponse;
import com.example.Real.Time.Chat.Application.service.JwtService;
import com.example.Real.Time.Chat.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest request)
    {
        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User savedUser = userService.registerUser(user);
        String token = jwtService.generateToken(savedUser.getEmail());

        return ResponseEntity.ok(new AuthResponse(token,
                savedUser.getId(),
                savedUser.getUsername()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request)
    {
        User user = userService.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User not found!!"));

        if(passwordEncoder.matches(request.getPassword(), user.getPassword()))
        {
            String token = jwtService.generateToken(user.getEmail());

            userService.updateUserStatus(user.getId(), true);

            return ResponseEntity.ok(new AuthResponse(token, user.getId(),user.getUsername()));
        }
        else {
            return ResponseEntity.status(401).body("Invalid credentials!!");
        }
    }
}
