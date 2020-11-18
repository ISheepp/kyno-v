package com.codelin.controller;

import com.codelin.bean.Hr;
import com.codelin.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ISheep
 * @create 2020/11/17 10:01
 *
 */

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    HrService hrService;

    // 获取所有用户但是不必获取当前用户
    @GetMapping("/hrs")
    public List<Hr> getAllHrs() {
        return hrService.getAllHrsExceptCurrentHr();
    }
}
