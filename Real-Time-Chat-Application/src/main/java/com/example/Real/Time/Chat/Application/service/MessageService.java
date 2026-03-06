package com.example.Real.Time.Chat.Application.service;

import com.example.Real.Time.Chat.Application.model.Message;
import com.example.Real.Time.Chat.Application.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(Message message)
    {
        message.setTimestamp(new Date());
        return messageRepository.save(message);
    }

    public List<Message> getChatMessages(String chatId)
    {
        return messageRepository.findByChatIdOrderByTimestampAsc(chatId);
    }
}
