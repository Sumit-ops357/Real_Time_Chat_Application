package com.example.Real.Time.Chat.Application.service;

import com.example.Real.Time.Chat.Application.model.Chat;
import com.example.Real.Time.Chat.Application.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public Chat createChat(Chat chat)
    {
        return chatRepository.save(chat);
    }

    public List<Chat> getUserChats(String userId)
    {
        return chatRepository.findByUsersContaining(userId);
    }

    public Chat getChatById(String chatId)
    {
        return chatRepository.findById(chatId).orElseThrow(() -> new RuntimeException("Chat not found!!"));
    }
}
