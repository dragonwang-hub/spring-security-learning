package com.security.learning.chapter4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/api")
public class AppController {

    @GetMapping("hello")
    private String hello() {
        return "Hello, App!";
    }
}
