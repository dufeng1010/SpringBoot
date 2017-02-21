package com.dufeng.goal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dufeng.goal.domain.Greeting;
import com.dufeng.goal.domain.Message;
import com.dufeng.goal.domain.User;
import com.dufeng.goal.service.IndexService;

@Controller
public class IndexController {
    
    @Autowired
    private IndexService helloService;
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @RequestMapping("/")
    public String index() {
        for(int i = 0; i < 5; i++) {
            stringRedisTemplate.convertAndSend("chat", "hello fengfengzai!");
        }
        
        List<User> users = helloService.getUsers();
        System.out.println(users.size());
        
        return "hello";
    }
    
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) throws Exception {
        Thread.sleep(1000);
        return new Greeting(1, message.getName());
    }
    
    @RequestMapping("/towebsockets")
    public String toWebSockets() {
        return "websockets";
    }
}
