package com.example.Real.Time.Chat.Application.repository;

import com.example.Real.Time.Chat.Application.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {

    List<Message> findByChatIdOrderByTimestampAsc(String chatId);
}
