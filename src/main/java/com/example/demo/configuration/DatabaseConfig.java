package com.example.demo.configuration;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class DatabaseConfig {

    @Value("${DATABASE_HOST}")
    private String databaseURL;
}

