package com.example.Real.Time.Chat.Application.controller;

import com.example.Real.Time.Chat.Application.model.Message;
import com.example.Real.Time.Chat.Application.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/{chatId}")
    public ResponseEntity<List<Message>> getChatMessages(@PathVariable String chatId)
    {
        return ResponseEntity.ok(messageService.getChatMessages(chatId));
    }
}
