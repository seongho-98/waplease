package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping(value = "/")
    public String main_page(){
        return "/mainpage/mainpage.html";
    }

    @GetMapping(value = "/login")
    public String login_page(){
        return "/login/login.html";
    }
}
