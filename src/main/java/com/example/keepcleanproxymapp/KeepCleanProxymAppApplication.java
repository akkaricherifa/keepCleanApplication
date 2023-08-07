package com.example.keepcleanproxymapp;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
@SpringBootApplication
public class KeepCleanProxymAppApplication {


    public static void main(String[] args) {
        SpringApplication.run(KeepCleanProxymAppApplication.class, args);
    }


}
