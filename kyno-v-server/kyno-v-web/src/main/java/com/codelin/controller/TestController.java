package com.codelin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ISheep
 * @create 2020/11/3 10:30
 * 测试thymeleaf页面重定向到vue页面
 */

@Controller
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "test";
    }

    @GetMapping("/test")
    public String test() {
        return "redirect:http://localhost:8080/";
    }
}
