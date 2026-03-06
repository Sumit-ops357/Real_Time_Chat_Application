package com.example.Real.Time.Chat.Application.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "chats")
public class Chat {

    @Id   //Primary key
    private String id;
    private String chatName;  // Null for private chats, used for groups
    private boolean isGroupChat;
    private List<String> users;  // List of user IDs
    private String latestMessageId;  // Pointer to the latest message
}
