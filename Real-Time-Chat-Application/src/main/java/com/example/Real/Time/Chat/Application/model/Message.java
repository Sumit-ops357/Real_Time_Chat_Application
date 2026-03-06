package com.example.Real.Time.Chat.Application.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data         //Includes getters, setters (Automatically)
@Document(collection = "messages")
public class Message {

    @Id  //Primary key
    private String id;
    private String senderId;
    private String chatId;
    private String content;
    private Date timestamp;
}
