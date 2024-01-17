package com.demo.chat.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j

public class WebSocketEventListener {

    /*This method gets called when user lefts the session*/
    public void handleWebSocketEventListener(SessionDisconnectEvent event)
    {
        //implement later on
    }
}
