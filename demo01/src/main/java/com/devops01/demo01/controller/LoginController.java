package com.devops01.demo01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devops01.demo01.service.LoginService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class LoginController {
    @Autowired
    private LoginService serv;

    @GetMapping("/")
    public String getInitialPage() {
        return "login";
    }
    
    @PostMapping("/login")
    public String loginData(@RequestParam String username,@RequestParam String password) {
        if(serv.logdata(username,password))
        {
            return "home";
        }
        return "login";
    }

    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup";
    }
    
    @PostMapping("/signup")
    public String SignupData(@RequestParam String username,@RequestParam String password) {
        if(serv.signdata(username,password)){
            return "home";
        }
        return "signup";
    }


    @GetMapping("/home")
    public String getMethodName(@RequestParam String param) {
        return "home";
    }

    
}
