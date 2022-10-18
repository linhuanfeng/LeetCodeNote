package com.lhf.jdbc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lhf.jdbc.pojo.User;

public interface UserService extends IService<User> {
    User login(User user);
}
