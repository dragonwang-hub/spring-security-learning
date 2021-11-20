package com.security.learning.chapter5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ApplicationChapter5 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationChapter5.class, args);
    }
}
