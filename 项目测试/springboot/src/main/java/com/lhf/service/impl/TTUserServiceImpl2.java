package com.lhf.service.impl;

import com.lhf.service.UserService;
import org.springframework.stereotype.Service;

@Service(value = "service2")
public class TTUserServiceImpl2 implements UserService {
    @Override
    public String select(Long id) {
        return "你好："+id;
    }
}
