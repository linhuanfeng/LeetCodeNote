package com.lhf.web;

import com.lhf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource // 反射机制使用byName自动注入策略
    private UserService userService1;

//    @Resource(name = "service1")
    private UserService userService2;
    @Autowired
    @Qualifier(value = "service2")
    private UserService userService3;

    @GetMapping("/list/{id}")
    public String id(@PathVariable(value = "id") Long id) {
        System.out.println(userService1); // 全是同一个
        System.out.println(userService2);
        System.out.println(userService3);
        return userService3.select(id);
    }

    @GetMapping("/info")
    public String id() {
        return userService1.select(1l);
    }
}
