package com.example.Real.Time.Chat.Application.controller;

import com.example.Real.Time.Chat.Application.model.Chat;
import com.example.Real.Time.Chat.Application.model.dto.CreateChatRequest;
import com.example.Real.Time.Chat.Application.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public ResponseEntity<Chat> createChat(@RequestBody CreateChatRequest request)
    {
        Chat chat = new Chat();

        chat.setChatName(request.getChatName());
        chat.setGroupChat(request.isGroupChat());
        chat.setUsers(request.getUsers());

        Chat savedChat = chatService.createChat(chat);
        return ResponseEntity.ok(savedChat);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Chat>> getUserChats(@PathVariable String userId)
    {
        return ResponseEntity.ok(chatService.getUserChats(userId));
    }
}
