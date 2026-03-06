package com.example.Real.Time.Chat.Application.model.dto;

import lombok.Data;

@Data   //Automatically creates getters and setters
public class AuthRequest {
    private String username;
    private String email;
    private String password;
}
