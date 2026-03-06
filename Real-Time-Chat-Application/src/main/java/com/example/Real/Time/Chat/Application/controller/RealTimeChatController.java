package com.example.Real.Time.Chat.Application.controller;

import com.example.Real.Time.Chat.Application.model.Message;
import com.example.Real.Time.Chat.Application.model.dto.ChatMessagePayload;
import com.example.Real.Time.Chat.Application.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class RealTimeChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private MessageService messageService;

    //Frontend sends messages to /app/chat.send
    @MessageMapping("/chat.send")
    public void processMessage(@Payload ChatMessagePayload payload)
    {
        //1. Save message to MongoDB
        Message message = new Message();
        message.setSenderId(payload.getSenderId());
        message.setChatId(payload.getChatId());
        message.setContent(payload.getContent());
        
        Message savedMessage = messageService.saveMessage(message);

        //2. Broadcast message to the specific chat room

        //Frontend will subscribe to /topic/chat/{chatId}

        messagingTemplate.convertAndSend("/topic/chat/" + payload.getChatId(),savedMessage);
    }
}
