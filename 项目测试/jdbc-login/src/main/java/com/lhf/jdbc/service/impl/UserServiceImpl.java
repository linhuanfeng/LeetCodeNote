package com.lhf.jdbc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhf.jdbc.dao.UserDao;
import com.lhf.jdbc.pojo.User;
import com.lhf.jdbc.service.UserService;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {
    @Override
    public User login(User user) {
        User one = this.baseMapper.selectOne(new QueryWrapper<User>().eq("username", user.getUsername())
                .eq("password",user.getPassword()));
        return one;
    }
}
