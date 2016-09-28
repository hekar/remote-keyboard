package com.hekar.remote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RemotekeyboardApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder =
                new SpringApplicationBuilder(RemotekeyboardApplication.class);
        builder.headless(false);
        builder.run(args);
    }
}
