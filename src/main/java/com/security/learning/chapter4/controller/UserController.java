package com.security.learning.chapter4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/api")
public class UserController {

    @GetMapping("/hello")
    public String user() {
        return "Hello, User";
    }
}
