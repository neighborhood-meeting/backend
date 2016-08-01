package com.nexters.neighborhood.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     * Health Check를 위한 Method.
     * @return String
     */
    @RequestMapping("/hello")
    public String healthCheck() {
        return "hello!";
    }
}