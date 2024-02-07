package com.example.SpringSecurity_005.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/about")
    public String about(){
        return "about";
    }
    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/fail")
    public String fail(){
        return "fail";
    }
}
