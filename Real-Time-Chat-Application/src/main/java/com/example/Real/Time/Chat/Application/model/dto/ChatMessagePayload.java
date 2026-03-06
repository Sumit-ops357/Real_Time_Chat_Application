package com.example.Real.Time.Chat.Application.model.dto;

import lombok.Data;

@Data
public class ChatMessagePayload {
    private String senderId;
    private String chatId;
    private String content;
}
