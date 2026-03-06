package com.example.Real.Time.Chat.Application.repository;

import com.example.Real.Time.Chat.Application.model.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRepository extends MongoRepository<Chat, String> {

    List<Chat> findByUsersContaining(String userId);
}
