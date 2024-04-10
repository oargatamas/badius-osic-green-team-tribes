package com.greenfox.exam.badiusosicgreentribes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class ApiController {

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }
}
