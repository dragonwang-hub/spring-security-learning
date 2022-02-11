package com.security.learning.chapter8.custom2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        System.out.println("enter hello controller");
        return "hello, world";
    }
}
