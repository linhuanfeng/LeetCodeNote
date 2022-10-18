package com.lhf.service.impl;

import com.lhf.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service(value = "service1")
@Primary
public class TTUserServiceImpl implements UserService {
    @Override
    public String select(Long id) {
        return "你好："+id;
    }
}
