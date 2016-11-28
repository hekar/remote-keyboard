package com.hekar.remote

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@SpringBootApplication
@EnableWebSocket
open class RemotekeyboardApplication : SpringBootServletInitializer(), WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(mouseWebSocketHandler(), "/ws").withSockJS()
    }

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(RemotekeyboardApplication::class.java)
    }

    @Bean
    open fun mouseWebSocketHandler(): WebSocketHandler {
        return MouseWebSocketController()
    }

    companion object {

        @JvmStatic fun main(args: Array<String>) {
            val builder = SpringApplicationBuilder(RemotekeyboardApplication::class.java)
            builder.headless(false)
            builder.run(*args)
        }
    }
}
