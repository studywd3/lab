package ru.wd3.study.controller;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController

public class DefaultController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/hostname")
    public String hostname(HttpServletRequest request) {
        return request.getServerName();
    }

}