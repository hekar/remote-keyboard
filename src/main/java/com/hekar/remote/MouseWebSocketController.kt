package com.hekar.remote

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

class MouseWebSocketController() : TextWebSocketHandler() {

    @Autowired
    lateinit var mouseService: MouseService

    override fun afterConnectionEstablished(session: WebSocketSession) {
        session.sendMessage(TextMessage("Hello world"))
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        val tokens = message.payload.split(":")
        val text = when (message.payload.elementAt(0)) {
            'm' -> mouseService.move(tokens[1].toInt(), tokens[2].toInt())
            's' -> mouseService.scroll(tokens[2].toInt())
            'c' -> mouseService.click()
            else -> "no message"
        }

        session.sendMessage(TextMessage(text))
    }

}
