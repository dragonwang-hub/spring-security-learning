package com.security.learning.chapter6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApplicationChapter6 implements CommandLineRunner {

    @Autowired
    private ApplicationContext appContext;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationChapter6.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(appContext.getBean("persistentTokenRepository"));
    }
}
