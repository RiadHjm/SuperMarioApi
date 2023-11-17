package com.mario.charactersapi;

import com.mario.charactersapi.config.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarioApplication.class, args);
    }

    @Bean
    public CorsConfig corsFilter() {
        return new CorsConfig();
    }

}
