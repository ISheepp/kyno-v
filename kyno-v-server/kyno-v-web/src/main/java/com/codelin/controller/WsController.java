package com.codelin.controller;

import com.codelin.bean.ChatMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Date;

/**
 * @author ISheep
 * @create 2020/11/17 10:25
 * 消息处理类
 */
@Controller
public class WsController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    /**
     * 处理前端发送消息的方法
     * @param principal 相当于hrUtils里的获取当前用户
     */
    @MessageMapping("/ws/chat")
    public void handleMsg(Principal principal, ChatMsg chatMsg) {
        // 使用json对象接收
        chatMsg.setFrom(principal.getName());
        chatMsg.setDate(new Date());
        simpMessagingTemplate.convertAndSendToUser(chatMsg.getTo(), "/queue/chat", chatMsg);
    }
}
