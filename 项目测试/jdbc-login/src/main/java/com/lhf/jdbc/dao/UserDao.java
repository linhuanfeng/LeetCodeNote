package com.lhf.jdbc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhf.jdbc.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Connection;

@Mapper
public interface UserDao extends BaseMapper<User> {
    User login(Connection connection,User user);
    void save(Connection connection,User user);
    User getUserByName(Connection connection,String userName);
}
