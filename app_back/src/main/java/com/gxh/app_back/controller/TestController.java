package com.gxh.app_back.controller;

import io.jsonwebtoken.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "hello springboot!!!";
    }

}
