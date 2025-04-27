package com.daniel.jobportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")    // khi truy cập đến endpoint này
    public String home(){
        return "index";   // thì controller sẽ điều hướng đến trang index.html
    }
}
