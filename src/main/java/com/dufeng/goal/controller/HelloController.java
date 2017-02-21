package com.dufeng.goal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dufeng.goal.domain.User;
import com.dufeng.goal.service.HelloService;

@Controller
public class HelloController {
    
    @Autowired
    private HelloService helloService;
    
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
}
