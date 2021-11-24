package com.security.learning.chapter7.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @GetMapping("/session")
    public String session() {
        return "hello, session";
    }
}
