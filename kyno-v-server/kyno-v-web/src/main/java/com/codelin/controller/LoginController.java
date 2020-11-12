package com.codelin.controller;

import com.codelin.bean.RespBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ISheep
 * @create 2020/10/23 19:32
 */

@RestController
public class LoginController {

    @GetMapping("/login")
    // @CrossOrigin("*") 解决跨域的方法  不推荐
    public RespBean login() {
        return RespBean.error("尚未登录，请登录!");
    }
}
