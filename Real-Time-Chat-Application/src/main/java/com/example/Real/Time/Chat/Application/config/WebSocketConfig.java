package com.example.Real.Time.Chat.Application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    //WebSocketMessageBroker allows uses to define Endpoints, prefixes
    //STOMP:-  Simple text Oriented Messaging protocol
    //Override:- These methods are already defined in the parent interface...i am using those methods in my class so i am overriding them

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry)
    {
        //The endpoint the frontend Next.js app will connect to

        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry)
    {
        //Prefix for pushing messages to clients

        //   /topic:- Group chat messages
        //   /user:-  Message to a particular client

        registry.enableSimpleBroker("/topic", "/user");

        //Prefix for excepting messages from clients

        registry.setApplicationDestinationPrefixes("/app");

        registry.setUserDestinationPrefix("/user");
    }
}
