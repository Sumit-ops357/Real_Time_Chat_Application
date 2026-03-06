package com.example.Real.Time.Chat.Application.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {

    @Id   //Primary key
    private String id;
    private String username;
    private String email;
    private String password;
    private String profilePic;
    private boolean isOnline;
}
