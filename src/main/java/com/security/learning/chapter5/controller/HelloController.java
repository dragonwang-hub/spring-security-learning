package com.security.learning.chapter5.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Secured("ROLE_USER")
    @GetMapping("/user/api/hello")
    public String helloUser() {
        System.out.println("enter hello user");
        return "hello user";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("admin/api/hello")
    public String helloAdmin() {
        System.out.println("enter hello admin");
        return "hello admin";
    }
}
