package com.example.Real.Time.Chat.Application.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateChatRequest {
    private String chatName;
    private boolean isGroupChat;
    private List<String> users;
}
