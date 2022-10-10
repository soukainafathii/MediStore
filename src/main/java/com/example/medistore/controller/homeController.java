package com.example.medistore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class homeController {

    @RequestMapping("/hello")
    @GetMapping
    public String getPage(){
        return "hello everybody";
    }

}
