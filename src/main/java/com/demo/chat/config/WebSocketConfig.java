package com.demo.chat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /*This method is used to configure websocket endpoint with SockJS (JS library)
     support.*/
    @Autowired
    private Environment env;
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
       // registry.enableSimpleBroker("/topic");
        registry.enableStompBrokerRelay("/topic")
                .setRelayHost(env.getProperty("spring.rabbitmq.host"))
                .setRelayPort((Integer.parseInt(env.getProperty("spring.rabbitmq.port"))))
                .setClientLogin(env.getProperty("spring.rabbitmq.username"))
                .setClientPasscode(env.getProperty("spring.rabbitmq.password"));

    }
}
