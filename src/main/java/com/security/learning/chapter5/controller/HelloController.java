package com.security.learning.chapter5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/user/api/hello")
    public String helloUser() {
        return "hello user";
    }

    @GetMapping("admin/api/hello")
    public String helloAdmin() {
        return "hello admin";
    }
}
