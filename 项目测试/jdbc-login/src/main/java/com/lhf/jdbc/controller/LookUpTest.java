package com.lhf.jdbc.controller;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lookup")
public class LookUpTest {
    // 单例bean获取原型bean，为了每次获取到最新的实例，spring提供了方法级别的注入,实现了与spring代码的解耦
    // 原理是当调用这个方法的时候，spring使用cglib动态代码，调用代理方法获取proto最新的对象
    // 如果使用applicationContext获取到bean的话，就跟spring代码耦合了
    @GetMapping("/proto")
    public String toy(){
        Toy toy = getToy();
        return "利用ciglib自动获取最新的proto对象:"+toy;
    }

    @Lookup // 自动获取最新的proto对象
    public Toy getToy(){
        return null;
    }
}
