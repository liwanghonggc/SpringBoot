package com.lwh.springboot.chp4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class TestController {

    @RequestMapping("/success")
    public String success(Model map){
        map.addAttribute("hello", "<h1>你好</h1>");
        map.addAttribute("users", Arrays.asList("lwh", "xcj", "yhb"));
        return "success";
    }
}
