package com.sqber.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
public class IndexController {

    @GetMapping("/")
    public String indexPage() {
        return "welcome to spring boot demo application";
    }

    @GetMapping("/test")
    public String test() {
        Properties properties = System.getProperties();
        String userdir = System.getProperty("user.dir");
        return "test";
    }
}
