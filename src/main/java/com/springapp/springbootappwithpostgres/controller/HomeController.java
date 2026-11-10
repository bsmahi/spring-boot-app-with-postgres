package com.springapp.springbootappwithpostgres.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome! OAuth2-Proxy authentication successful.";
    }
}
