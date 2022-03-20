package com.gzh.springbootshiro.service.impl;

import com.gzh.springbootshiro.entity.User;
import com.gzh.springbootshiro.mapper.UserMapper;
import com.gzh.springbootshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GZH
 * @date 2021-12-10
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }
}
