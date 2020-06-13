package com.example.demo.controllers.access;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@Configuration
public class LoginController {

    @GetMapping("/login")
    public String loggingProcess(){
        return "/WEB-INF/views/loginForm.jsp";
    }


}
