package com.lwh.springboot.chp4.controller;

import com.lwh.springboot.chp4.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class TestController {

    @RequestMapping("/success")
    public String success(Model map){
        map.addAttribute("hello", "<h1>你好</h1>");
        map.addAttribute("users", Arrays.asList("lwh", "xcj", "yhb"));
        return "success";
    }

    @ResponseBody
    @RequestMapping("/test")
    public String hello(@RequestParam("user") String user){
        if("aaa".equals(user)){
            throw new UserNotExistException();
        }
        return "Hello world";
    }
}
