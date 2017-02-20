package com.dufeng.goal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dufeng.goal.domain.User;
import com.dufeng.goal.service.HelloService;

@RestController
public class HelloController {
    
    @Autowired
    private HelloService helloService;
    
    @RequestMapping("/")
    public String index() {
        List<User> users = helloService.getUsers();
        System.out.println(users.size());
        
        return "Hello, dufeng";
    }
}
