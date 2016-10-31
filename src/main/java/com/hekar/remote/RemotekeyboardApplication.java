package com.hekar.remote;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@SpringBootApplication
@EnableWebSocket
public class RemotekeyboardApplication extends SpringBootServletInitializer implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(mouseWebSocketHandler(), "/ws").withSockJS();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RemotekeyboardApplication.class);
    }

    @Bean
    public WebSocketHandler mouseWebSocketHandler() {
        return new MouseWebSocketController();
    }

    public static void main(String[] args) {
        SpringApplicationBuilder builder =
                new SpringApplicationBuilder(RemotekeyboardApplication.class);
        builder.headless(false);
        builder.run(args);
    }
}
